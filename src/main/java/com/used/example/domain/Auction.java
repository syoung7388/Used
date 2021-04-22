package com.used.example.domain;

import java.util.List;

public class Auction {
	
	private int a_num;
	private int p_num;
	private long price;
	private String participant;
	private String aTime;// 옥션 참가자가 돈제안 시간
	private int order;

	
	
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
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
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Auction [a_num=" + a_num + ", p_num=" + p_num + ", price=" + price + ", participant=" + participant
				+ ", aTime=" + aTime + ", order=" + order + "]";
	}

	
	
	
	
	
	

	

}
