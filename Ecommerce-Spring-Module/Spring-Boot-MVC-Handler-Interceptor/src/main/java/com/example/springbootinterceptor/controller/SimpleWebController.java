package com.example.springbootinterceptor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleWebController {
Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		log.info("Welcome to access RequestMapping: /hello!");
		return "Hello World!";
	}
	@RequestMapping(value="/hello1",method=RequestMethod.GET)
	public String hello1(){
		log.info("Welcome to access RequestMapping: /hello!");
		return "Hello World!";
	}
	@RequestMapping(value="/hello2",method=RequestMethod.GET)
	public String hello2(){
		log.info("Welcome to access RequestMapping: /hello!");
		return "Hello World! ";
	}
}
