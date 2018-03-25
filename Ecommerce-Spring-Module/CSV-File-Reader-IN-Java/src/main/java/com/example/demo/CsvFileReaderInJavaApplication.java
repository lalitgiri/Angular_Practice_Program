package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CsvFileReaderInJavaApplication {

	public static void main(String[] args) {
	//	SpringApplication.run(CsvFileReaderInJavaApplication.class, args);
		
		String fileName  = "target/User Data.csv";
		File file=new File(fileName);

		try {
			Scanner inputStream =new Scanner(file);
			
			while (inputStream.hasNext()) {
				String data =inputStream.next();
				System.out.println(data);
			}
		
			inputStream.close(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
