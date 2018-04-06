package com.ecommerce.main.serverConfigurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ecommerce.main.interceptors.LoginInterceptor;

@EnableWebMvc
@Configuration
public class InterceptorRegistory extends WebMvcConfigurerAdapter {

	  @Override
	    public void addInterceptors (InterceptorRegistry registry) {
	        registry.addInterceptor(new LoginInterceptor());
	    }
}
