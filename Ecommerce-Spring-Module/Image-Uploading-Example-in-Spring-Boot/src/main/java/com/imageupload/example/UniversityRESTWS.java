package com.imageupload.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UniversityRESTWS {

	private MultipartFile pic;
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
		pic=file;
		if(pic!=null)
		{
			System.out.println("Inside pic uploading block .");
			File convertFile=new File(URLPaths.IMG_PATH+"/hello/"+pic.getOriginalFilename());
			System.out.println(URLPaths.IMG_PATH+pic.getOriginalFilename());
			convertFile.getParentFile().mkdirs();
			
			convertFile.createNewFile();
			FileOutputStream fout1 =new FileOutputStream(convertFile);
			fout1.write(pic.getBytes());
			fout1.close();
			return URLPaths.IMG_PATH+pic.getOriginalFilename();
		}
		return "not";
	}
	@RequestMapping(value="/uploaddata",method=RequestMethod.POST)
	public String uploadData(@RequestBody byte[] abc ) throws IOException {
		
			FileOutputStream fout = new FileOutputStream("datafile.txt");
			fout.write(abc);
			fout.close();
			
		return "File Is Uploaded Sucessfully";
	}
}
