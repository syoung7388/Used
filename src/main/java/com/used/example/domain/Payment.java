package com.used.example.domain;

public class Payment {
	private int pa_num;
	private int a_num;
	private int o_num;

	
	
	
	public int getPa_num() {
		return pa_num;
	}
	public void setPa_num(int pa_num) {
		this.pa_num = pa_num;
	}
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public int getO_num() {
		return o_num;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	@Override
	public String toString() {
		return "Payment [pa_num=" + pa_num + ", a_num=" + a_num + ", o_num=" + o_num + "]";
	}

	
	
	
	
	

}
