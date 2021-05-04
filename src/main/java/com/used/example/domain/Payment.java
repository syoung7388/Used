package com.used.example.domain;

public class Payment {
	private int pa_num;
	private String pa_username;
	private String method; 
	private String kind; 
	private String Patime; 
	private int a_num; 
	private int p_num;
	private String cop;
	private Card card;
	private Amount amount;
	private int quantity;
	
	
	public int getPa_num() {
		return pa_num;
	}
	public void setPa_num(int pa_num) {
		this.pa_num = pa_num;
	}
	public String getPa_username() {
		return pa_username;
	}
	public void setPa_username(String pa_username) {
		this.pa_username = pa_username;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPatime() {
		return Patime;
	}
	public void setPatime(String patime) {
		Patime = patime;
	}
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
	public String getCop() {
		return cop;
	}
	public void setCop(String cop) {
		this.cop = cop;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [pa_num=" + pa_num + ", pa_username=" + pa_username + ", method=" + method + ", kind=" + kind
				+ ", quantity=" + quantity + ", Patime=" + Patime + ", a_num=" + a_num + ", p_num=" + p_num + ", cop="
				+ cop + ", card=" + card + ", amount=" + amount + "]";
	}
	
	
	

}
