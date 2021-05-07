package com.used.example.domain;

public class Count {
	private int salecount;
	private int paycount;
	private int soldcount;
	public int getSalecount() {
		return salecount;
	}
	public void setSalecount(int salecount) {
		this.salecount = salecount;
	}
	public int getPaycount() {
		return paycount;
	}
	public void setPaycount(int paycount) {
		this.paycount = paycount;
	}
	public int getSoldcount() {
		return soldcount;
	}
	public void setSoldcount(int soldcount) {
		this.soldcount = soldcount;
	}
	@Override
	public String toString() {
		return "Count [salecount=" + salecount + ", paycount=" + paycount + ", soldcount=" + soldcount + "]";
	}
	
	
	

}
