package com.used.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.used.example.domain.Amount;
import com.used.example.domain.Auction;
import com.used.example.domain.Card;
import com.used.example.domain.KaKaoReady;
import com.used.example.domain.KakaoAmount;
import com.used.example.domain.KakaoApproval;
import com.used.example.domain.KakaoCardInfo;
import com.used.example.domain.Payment;
import com.used.example.domain.Product;

@Mapper
public interface PaymentMapper {

	public Payment PaymentDetail(int a_num);

	public List<Auction> PayList(String o_username);

	public void CreatePayment(Payment payment);

	public List<KaKaoReady> SelectPaymenet(String today);

	public void CreateCard(Card card);

	public void CreateAmount(Amount amount);

	public void PayStep(Payment payment);

}
