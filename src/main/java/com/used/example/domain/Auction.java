package com.used.example.domain;

public class Auction {
	
	private int a_num;
	private String price;
	private String participant;
	private String aTime;// 옥션 참가자가 돈제시한 시간
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getParticipant() {
		return participant;
	}
	public void setParticipant(String participant) {
		this.participant = participant;
	}
	public String getaTime() {
		return aTime;
	}
	public void setaTime(String aTime) {
		this.aTime = aTime;
	}
	
	

}
