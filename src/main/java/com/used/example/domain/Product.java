package com.used.example.domain;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;



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
 	private String p_date;
	private String sale;
	private String address;
	private String lat;
	private String lon;
	private long topprice;
	private List<Picture> picture;
	private List<Auction> auction;
	private String enddate;
	private String d_day;
	
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	public String getSale() {
		return sale;
	}
	public void setSale(String sale) {
		this.sale = sale;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
	public long getTopprice() {
		return topprice;
	}
	public void setTopprice(long topprice) {
		this.topprice = topprice;
	}
	public List<Picture> getPicture() {
		return picture;
	}
	public void setPicture(List<Picture> picture) {
		this.picture = picture;
	}
	public List<Auction> getAuction() {
		return auction;
	}
	public void setAuction(List<Auction> auction) {
		this.auction = auction;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
	
	
	
	
	

	public String getD_day() {
		return d_day;
	}
	public void setD_day(String d_day) {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//		String today= format.format(new Date());
//		String day=  format.format(d_day+"23:59:59");
//		Date Today = format.parse(today);
//		Date Dday = format.parse(day);
//		
//		long dday= Today.getTime()-Dday.getTime();
//		long diffDays = dday / (24 * 60 * 60 * 1000);
//
//	
//		
//		System.out.println("d_day"+diffDays);
		this.d_day = d_day;
		
		
	}
	
	



	
	
}