package com.used.example.service;

import java.util.List;

import com.used.example.domain.Auction;
import com.used.example.domain.Payment;
import com.used.example.domain.Product;

public interface PaymentService {

	public Product PaymentDetail(int p_num);

	public List<Auction> PayList(String o_username);

	public void CreatePayment(List<Payment> list);

	public List<Payment> SelectPaymenet(String today);

}
