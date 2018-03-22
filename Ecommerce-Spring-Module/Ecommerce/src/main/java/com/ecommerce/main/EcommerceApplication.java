package com.ecommerce.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Configuration
public class EcommerceApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		
		SpringApplication.run(EcommerceApplication.class, args);
	}
}
