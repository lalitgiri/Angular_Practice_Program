package com.ecommerce.main;


import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CORSConfiguration extends WebMvcConfigurerAdapter {

 @Bean
 public WebMvcConfigurer corsConfigurer() {
   return new WebMvcConfigurerAdapter() {
     @Override
     public void addCorsMappings(final CorsRegistry registry) {
       registry.addMapping("/**").allowedMethods("*");
     }
   };
 }
 
 @Override
 public void addResourceHandlers(ResourceHandlerRegistry registry) {
     registry
       .addResourceHandler("/images/**")
       .addResourceLocations(new File(".").toURI().toString()); 
 }


}
