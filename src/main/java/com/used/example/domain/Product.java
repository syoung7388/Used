package com.used.example.domain;



import java.text.DateFormat;


import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;



public class Product {
	
	
	
	private int p_num;
	private String kind;
	private String brand;
	private String year;
	private String industry;
	
	private List<Picture> picture;

	@Override
	public String toString() {
		return "Product [p_num=" + p_num + ", kind=" + kind + ", brand=" + brand + ", year=" + year + ", industry="
				+ industry + ", picture=" + picture + "]";
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public List<Picture> getPicture() {
		return picture;
	}

	public void setPicture(List<Picture> picture) {
		this.picture = picture;
	}
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	



	
	
}