package com.used.example.service;

import java.util.List;

import com.used.example.domain.Auction;
import com.used.example.domain.KaKaoReady;
import com.used.example.domain.Product;

public interface PaymentService {

	public Product PaymentDetail(int p_num);

	public List<Auction> PayList(String o_username);

	public void CreatePayment(List<KaKaoReady> list);

	public List<KaKaoReady> SelectPaymenet(String today);

}
