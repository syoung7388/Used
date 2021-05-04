package com.used.example.domain;

import lombok.Data;

@Data
public class KakaoAmount {
	private int total; // 총액
	private int tax_free; // 비과세 금액
	private int vat; // 부가세
	private int point;
	private int discount;
	private int pa_num;

}
