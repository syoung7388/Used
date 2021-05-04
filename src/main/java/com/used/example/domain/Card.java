package com.used.example.domain;


public class Card {
	
	
	private int c_num;
	private long bin;
	private String type; 
	private String install_month; 
	private long approved_id; 
	private String mid; 
	private String interest_free_install; 

	private int pa_num;
	public int getC_num() {
		return c_num;
	}
	public void setC_num(int c_num) {
		this.c_num = c_num;
	}
	public long getBin() {
		return bin;
	}
	public void setBin(long bin) {
		this.bin = bin;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInstall_month() {
		return install_month;
	}
	public void setInstall_month(String install_month) {
		this.install_month = install_month;
	}
	public long getApproved_id() {
		return approved_id;
	}
	public void setApproved_id(long approved_id) {
		this.approved_id = approved_id;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getInterest_free_install() {
		return interest_free_install;
	}
	public void setInterest_free_install(String interest_free_install) {
		this.interest_free_install = interest_free_install;
	}

	public int getPa_num() {
		return pa_num;
	}
	public void setPa_num(int pa_num) {
		this.pa_num = pa_num;
	}
	@Override
	public String toString() {
		return "Card [c_num=" + c_num + ", bin=" + bin + ", type=" + type + ", install_month=" + install_month
				+ ", approved_id=" + approved_id + ", mid=" + mid + ", interest_free_install="
				+ interest_free_install + ", pa_num=" + pa_num + "]";
	}

	
	

}
