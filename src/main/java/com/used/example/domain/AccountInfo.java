package com.used.example.domain;

public class AccountInfo {
	
	
	private int current_rate;// 유동비율
	private int debt_rate;//부채비율
	private double capital_turnover;//총자산 회전율
	private double store_turnover;//재고자산 회전율
	private double credit_turnover; // 매출채권 회전율
	private int sale_income_rate;// 매출 순이익
	private String ac_times;

	@Override
	public String toString() {
		return "AccountInfo [current_rate=" + current_rate + ", debt_rate=" + debt_rate + ", capital_turnover="
				+ capital_turnover + ", store_turnover=" + store_turnover + ", credit_turnover=" + credit_turnover
				+ ", sale_income_rate=" + sale_income_rate + ", ac_times=" + ac_times + "]";
	}
	public int getCurrent_rate() {
		return current_rate;
	}
	public void setCurrent_rate(int current_rate) {
		this.current_rate = current_rate;
	}
	public int getDebt_rate() {
		return debt_rate;
	}
	public void setDebt_rate(int debt_rate) {
		this.debt_rate = debt_rate;
	}
	public double getCapital_turnover() {
		return capital_turnover;
	}
	public void setCapital_turnover(double capital_turnover) {
		this.capital_turnover = capital_turnover;
	}
	public double getStore_turnover() {
		return store_turnover;
	}
	public void setStore_turnover(double store_turnover) {
		this.store_turnover = store_turnover;
	}
	public double getCredit_turnover() {
		return credit_turnover;
	}
	public void setCredit_turnover(double credit_turnover) {
		this.credit_turnover = credit_turnover;
	}
	public int getSale_income_rate() {
		return sale_income_rate;
	}
	public void setSale_income_rate(int sale_income_rate) {
		this.sale_income_rate = sale_income_rate;
	}
	public String getAc_times() {
		return ac_times;
	}
	public void setAc_times(String ac_times) {
		this.ac_times = ac_times;
	}


	
	
	

	
	

}
