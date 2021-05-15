package com.used.example.domain;

import java.util.List;

public class AccountList {
	private List<Account> list;

	@Override
	public String toString() {
		return "ListAccount [list=" + list + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public List<Account> getList() {
		return list;
	}

	public void setList(List<Account> list) {
		this.list = list;
	}
	

}
