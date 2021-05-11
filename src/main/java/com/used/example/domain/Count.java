package com.used.example.domain;

public class Count {
	private int salecount;
	private int paycount;
	private int tradecount;
	private int soldcount;
	@Override
	public String toString() {
		return "Count [salecount=" + salecount + ", paycount=" + paycount + ", tradecount=" + tradecount
				+ ", soldcount=" + soldcount + "]";
	}
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
	public int getTradecount() {
		return tradecount;
	}
	public void setTradecount(int tradecount) {
		this.tradecount = tradecount;
	}
	public int getSoldcount() {
		return soldcount;
	}
	public void setSoldcount(int soldcount) {
		this.soldcount = soldcount;
	}
	
	
	
	
	
	

}
