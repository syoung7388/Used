package com.used.example.domain;

public class Bid_request {
	
	
	private String o_username;
	private int sale;

	public String getO_username() {
		return o_username;
	}
	public void setO_username(String o_username) {
		this.o_username = o_username;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	@Override
	public String toString() {
		return "Bid_request [o_username=" + o_username + ", sale=" + sale + "]";
	}
	
}
