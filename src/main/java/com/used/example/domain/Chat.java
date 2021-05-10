package com.used.example.domain;

import java.util.List;

public class Chat {
	
	private int ch_num;
	private String seller;
	private String buyer;
	private int a_num;

	private List<Message> message;
	
	
	
	
	public int getCh_num() {
		return ch_num;
	}




	public void setCh_num(int ch_num) {
		this.ch_num = ch_num;
	}




	public String getSeller() {
		return seller;
	}




	public void setSeller(String seller) {
		this.seller = seller;
	}




	public String getBuyer() {
		return buyer;
	}




	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}




	public int getA_num() {
		return a_num;
	}




	public void setA_num(int a_num) {
		this.a_num = a_num;
	}




	public List<Message> getMessage() {
		return message;
	}




	public void setMessage(List<Message> message) {
		this.message = message;
	}




		@Override
	public String toString() {
		return "Chat [ch_num=" + ch_num + ", seller=" + seller + ", buyer=" + buyer + ", a_num=" + a_num + ", message="
				+ message + "]";
	}
	


	
	
	
	

}
