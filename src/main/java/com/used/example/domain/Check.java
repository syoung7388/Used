package com.used.example.domain;

public class Check {
	private int check_username;
	private int check_name;
	@Override
	public String toString() {
		return "Check [check_username=" + check_username + ", check_name=" + check_name + "]";
	}
	public int getCheck_username() {
		return check_username;
	}
	public void setCheck_username(int check_username) {
		this.check_username = check_username;
	}
	public int getCheck_name() {
		return check_name;
	}
	public void setCheck_name(int check_name) {
		this.check_name = check_name;
	}
	
	
	

}
