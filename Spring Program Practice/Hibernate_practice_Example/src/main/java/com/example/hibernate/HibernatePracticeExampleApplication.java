package com.example.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernatePracticeExampleApplication {

	public static void main(String[] args) {
		
		
		ManageEmployee obj =new ManageEmployee();
		obj.method();
	}
}
