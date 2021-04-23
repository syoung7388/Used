package com.used.example.domain;

public class Like {
	private int p_num;
	private String l_username;
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getL_username() {
		return l_username;
	}
	public void setL_username(String l_username) {
		this.l_username = l_username;
	}
	@Override
	public String toString() {
		return "Like [p_num=" + p_num + ", l_username=" + l_username + "]";
	}
	
	


}
