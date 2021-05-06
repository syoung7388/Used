package com.used.example.domain;

public class Pagination {
	
	int limit;
	int nowpage;
	int allpage;
	int count;
	
	
	public static final int perPage=12;
	@Override
	public String toString() {
		return "Pagenation [limit=" + limit + ", nowpage=" + nowpage + ", allpage=" + allpage + ", count=" + count
				+ "]";
	}
	public Pagination(int count, int page) {
		
		this.nowpage = page;
		this.count = count;
		this.allpage = (int) Math.ceil(count*1.0/ perPage);
		this.limit= page*perPage;
		
	}
	public Pagination() {
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getAllpage() {
		return allpage;
	}
	public void setAllpage(int allpage) {
		this.allpage = allpage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPerpage() {
		return perPage;
	}

	
	
	
	
	

}
