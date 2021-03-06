package com.used.example.config;




import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	

	   @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	            //.allowedOrigins("http://192.168.50.124:8080/")//"http://172.30.1.33:8080"
	        	//.allowedOrigins("http://172.30.1.12:8080")
	        	.allowedOrigins("http://3.34.22.100:80")
	        	.allowedMethods("*")
	        	.exposedHeaders("jwt-token");
	    }



}
