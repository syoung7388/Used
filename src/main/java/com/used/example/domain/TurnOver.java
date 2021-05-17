package com.used.example.domain;

public class TurnOver {
	private int t_num;
	private int year;
	private int month;
	private long amount;
	public int getT_num() {
		return t_num;
	}
	public void setT_num(int t_num) {
		this.t_num = t_num;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "TurnOver [t_num=" + t_num + ", year=" + year + ", month=" + month + ", amount=" + amount + "]";
	}

	

}
