package com.used.example.config;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.used.example.UsedApplication;
import com.used.example.date.DateForm;
import com.used.example.utility.MakeThumbnail;

@Configuration
@ComponentScan(basePackageClasses = UsedApplication.class)
public class ApplicationConfig {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Bean
	public MakeThumbnail makeThumbnail() {
		 return new MakeThumbnail();		 
	}
	
	
	@Bean
	public DateForm dateForm() {	
		return new DateForm();
	}
	

	
	
	
	

}
