package com.used.example.domain;



import java.util.Arrays;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;


//	private Picture picture;	
//	public Picture getPicture() {
//		return picture;
//	}
//	public void setPicture(Picture picture) {
//		this.picture = picture;
//	}


public class Product {
	
	private int p_num;
	private String username;
	
	
	private String kind;
	private String industry;
	private String brand;
	private String year;
	private String startprice;
	private String endprice;
	private String title;
	private String content;
    private List<Picture> picture;
 	private String p_date;
	private String sale;
	private String address;
	
	
	public List<Picture> getPicture() {
		return picture;
	}
	public void setPicture(List<Picture> picture) {
		this.picture = picture;
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
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Product [p_num=" + p_num + ", username=" + username + ", kind=" + kind + ", industry=" + industry
				+ ", brand=" + brand + ", year=" + year + ", startprice=" + startprice + ", endprice=" + endprice
				+ ", title=" + title + ", content=" + content + ", picture=" + picture + ", p_date=" + p_date
				+ ", sale=" + sale + ", address=" + address + "]";
	}

	
	
	

	
	
}