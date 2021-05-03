package com.used.example.domain;



// 변수의 규칙성 !! 독보적 칼럼 = table약자 떼고 사용함 // 여러 테이블에서 겹치면 'O'사용 // 만약 num값라면 칼럼명 그대로 사용

public class Offer {
	
	
	private int o_num;
	private int a_num;
	private String o_username;
	private long price;
	private String time;
	
	private int select;
	private int pay;
	private int skip;
	private int count;

	public int getO_num() {
		return o_num;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public String getO_username() {
		return o_username;
	}
	public void setO_username(String o_username) {
		this.o_username = o_username;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public int getSelect() {
		return select;
	}
	public void setSelect(int select) {
		this.select = select;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getSkip() {
		return skip;
	}
	public void setSkip(int skip) {
		this.skip = skip;
	}
	@Override
	public String toString() {
		return "Offer [o_num=" + o_num + ", a_num=" + a_num + ", o_username=" + o_username + ", price=" + price
				+ ", time=" + time + ", select=" + select + ", pay=" + pay + ", skip=" + skip + "]";
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}


	
	
	
	
	
	
	
	

	
	

}
