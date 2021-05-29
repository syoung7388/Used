package com.used.example.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.used.example.date.DateForm;

public class Auction {
	
	
	@Autowired
	DateForm dateForm;
	
	
	private int a_num;
	private String a_username;
	private String startdate;
	private String enddate;
	private long startprice;
	private int sale;
	private int hits;
	private int day;
	private long d_day;
	
	private String title;
	private String content;
	
	private List<Product> product;
	private List <Like> like;
	private List<Offer> offer;
	private Address address;
	private Payment payment;
	
	private Product pro;
	private long topprice;
	private int count;
	private int limit;
	
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
	
		this.day = day; 
		String e_date = DateForm.getEndDate(day);
		this.enddate = e_date;
	}
	
	
	public long getD_day() {
		return d_day;
	}
	public void setD_day(String d_day) throws Exception {
		
		this.enddate = d_day;	
		Long diffDays =dateForm.getD_day(this.enddate);
		this.d_day = diffDays;

	}
	
	
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public String getA_username() {
		return a_username;
	}
	public void setA_username(String a_username) {
		this.a_username = a_username;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public long getStartprice() {
		return startprice;
	}
	public void setStartprice(long startprice) {
		this.startprice = startprice;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
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
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public List<Like> getLike() {
		return like;
	}
	public void setLike(List<Like> like) {
		this.like = like;
	}
	public List<Offer> getOffer() {
		return offer;
	}
	public void setOffer(List<Offer> offer) {
		this.offer = offer;
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	public Product getPro() {
		return pro;
	}
	public void setPro(Product pro) {
		this.pro = pro;
	}
	public long getTopprice() {
		return topprice;
	}
	public void setTopprice(long topprice) {
		this.topprice = topprice;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	@Override
	public String toString() {
		return "Auction [dateForm=" + dateForm + ", a_num=" + a_num + ", a_username=" + a_username + ", startdate="
				+ startdate + ", enddate=" + enddate + ", startprice=" + startprice + ", sale=" + sale + ", hits="
				+ hits + ", day=" + day + ", d_day=" + d_day + ", title=" + title + ", content=" + content
				+ ", product=" + product + ", like=" + like + ", offer=" + offer + ", address=" + address + ", payment="
				+ payment + ", pro=" + pro + ", topprice=" + topprice + ", count=" + count + ", limit=" + limit + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

}
