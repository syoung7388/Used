package com.used.example.request;

public class Signuprequest {
	private String phone;
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	
	@Override
	public String toString() {
		return "SignupRequest[phone="+phone+"]";
	}
	

}
