package com.used.example.service;

import java.util.List;

import com.used.example.domain.Amount;
import com.used.example.domain.Auction;
import com.used.example.domain.Card;
import com.used.example.domain.KaKaoReady;
import com.used.example.domain.KakaoAmount;
import com.used.example.domain.KakaoApproval;
import com.used.example.domain.KakaoCardInfo;
import com.used.example.domain.Payment;
import com.used.example.domain.Product;

public interface PaymentService {

	public Payment PaymentDetail(int a_num);

	public List<Auction> PayList(String o_username);

	public void CreatePayment(Payment payment);

	public List<KaKaoReady> SelectPaymenet(String today);

	public void CreateCard(Card card);

	public void CreateAmount(Amount amount);

}
