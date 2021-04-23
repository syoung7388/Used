package com.used.example.domain;

public class Like {
	private int p_num;
	private String username;
	
	
	@Override
	public String toString() {
		return "Like [p_num=" + p_num + ", username=" + username + "]";
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
