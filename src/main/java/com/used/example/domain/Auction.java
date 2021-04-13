package com.used.example.domain;

public class Auction {
	
	private int p_num;
	private String price;
	private String participant;
	private String aTime;// 옥션 참가자가 돈제안 시간
	
	
	

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
	@Override
	public String toString() {
		return "Auction [p_num=" + p_num + ", price=" + price + ", participant=" + participant + ", aTime=" + aTime
				+ "]";
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	
	
	

}
