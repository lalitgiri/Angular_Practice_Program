package com.ecommerce.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecommerce.main.dao.CartDetails;
import com.ecommerce.main.dao.UserDetails;


@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(EcommerceApplication.class, args);
	}
}
