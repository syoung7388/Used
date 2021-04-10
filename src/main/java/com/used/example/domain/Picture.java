package com.used.example.domain;


public class Picture {
	
	private int p_num;
	private int pi_num;
	private String picture;
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public int getPi_num() {
		return pi_num;
	}
	public void setPi_num(int pi_num) {
		this.pi_num = pi_num;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "Picture [p_num=" + p_num + ", pi_num=" + pi_num + ", picture=" + picture + "]";
	}
	
	
	

}
