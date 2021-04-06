package com.used.example.domain;

import java.util.ArrayList;

public class Product {
	
	private int p_num;
	private String industry;
	private String kind;
	private String brand;
	private String year;
	private ArrayList<String> imageList;
	private int like;
	
	private String startprice;
	private String endprice;
	
	
	
	private int b_number;
	
	
	
	

	
	
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
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
	public String getStartprice() {
		return startprice;
	}
	public void setStartprice(String startprice) {
		this.startprice = startprice;
	}
	public ArrayList<String> getImageList() {
		return imageList;
	}
	public void setImageList(ArrayList<String> imageList) {
		this.imageList = imageList;
	}

	public String getEndprice() {
		return endprice;
	}
	public void setEndprice(String endprice) {
		this.endprice = endprice;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public int getB_number() {
		return b_number;
	}
	public void setB_number(int b_number) {
		this.b_number = b_number;
	}
}
