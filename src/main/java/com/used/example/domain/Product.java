package com.used.example.domain;

import java.util.ArrayList;

public class Product {
	
	private int p_num;
	private String username;
	
	
	private String kind;
	private String industry;
	private String brand;
	private String year;
	private ArrayList<String> imageList;
	private String startprice;
	private String endprice;
	private String title;
	private String content;
	
	
	
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
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
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
	public ArrayList<String> getImageList() {
		return imageList;
	}
	public void setImageList(ArrayList<String> imageList) {
		
		
		for(int i=0; i<imageList.size(); i++) {
			String originalFileName= imageList.get(i).
		}
		this.imageList = imageList;
	}
	public String getStartprice() {
		return startprice;
	}
	public void setStartprice(String startprice) {
		this.startprice = startprice;
	}
	public String getEndprice() {
		return endprice;
	}
	public void setEndprice(String endprice) {
		this.endprice = endprice;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	public String toString() {
		return "Product [p_num=" + p_num + ", username=" + username + ", kind=" + kind + ", industry=" + industry
				+ ", brand=" + brand + ", year=" + year + ", imageList=" + imageList + ", startprice=" + startprice
				+ ", endprice=" + endprice + ", title=" + title + ", content=" + content + "]";
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
