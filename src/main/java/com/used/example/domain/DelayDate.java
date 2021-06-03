package com.used.example.domain;

import java.util.Date;

public class DelayDate {
	private int a_num;
	private int day;
	private Date enddate;
	private String end_date;
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	@Override
	public String toString() {
		return "DelayDate [a_num=" + a_num + ", day=" + day + ", enddate=" + enddate + ", end_date=" + end_date + "]";
	}
	
	

}
