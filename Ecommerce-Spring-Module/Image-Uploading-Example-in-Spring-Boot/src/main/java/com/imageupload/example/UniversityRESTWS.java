package com.imageupload.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UniversityRESTWS {

	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		File convertFile=new File(URLPaths.IMG_PATH+file.getOriginalFilename());
		System.out.println(URLPaths.IMG_PATH+file.getOriginalFilename());
		convertFile.getParentFile().mkdirs();
		try {
			convertFile.createNewFile();
			FileOutputStream fout =new FileOutputStream(convertFile);
			fout.write(file.getBytes());
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "IO Error";
		}
		
		return "File Is Uploaded Sucessfully";
	}
}
