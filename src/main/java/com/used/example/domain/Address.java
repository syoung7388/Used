package com.used.example.domain;

public class Address {
	
	private int ad_num;
	private int a_num;
	private String lat;
	private String lon;
	private String addr;
	private String town;
	@Override
	public String toString() {
		return "Address [ad_num=" + ad_num + ", a_num=" + a_num + ", lat=" + lat + ", lon=" + lon + ", addr=" + addr
				+ ", town=" + town + "]";
	}
	public int getAd_num() {
		return ad_num;
	}
	public void setAd_num(int ad_num) {
		this.ad_num = ad_num;
	}
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	
	
	
	
	
	
	

}
