package com.used.example.domain;


public class Amount {
	
	
	private int am_num;
	private int tax_free;
	private int vat;
	private int point;
	private int discount;
	private long total;
	private int pa_num;
	public int getAm_num() {
		return am_num;
	}
	public void setAm_num(int am_num) {
		this.am_num = am_num;
	}
	public int getTax_free() {
		return tax_free;
	}
	public void setTax_free(int tax_free) {
		this.tax_free = tax_free;
	}
	public int getVat() {
		return vat;
	}
	public void setVat(int vat) {
		this.vat = vat;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public int getPa_num() {
		return pa_num;
	}
	public void setPa_num(int pa_num) {
		this.pa_num = pa_num;
	}
	@Override
	public String toString() {
		return "Amount [am_num=" + am_num + ", tax_free=" + tax_free + ", vat=" + vat + ", point=" + point
				+ ", discount=" + discount + ", total=" + total + ", pa_num=" + pa_num + "]";
	}

	
	
	

}
