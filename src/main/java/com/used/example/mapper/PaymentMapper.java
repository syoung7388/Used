package com.used.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.used.example.domain.Auction;
import com.used.example.domain.KaKaoReady;
import com.used.example.domain.KakaoAmount;
import com.used.example.domain.KakaoApproval;
import com.used.example.domain.KakaoCardInfo;
import com.used.example.domain.Product;

@Mapper
public interface PaymentMapper {

	public Product PaymentDetail(int p_num);

	public List<Auction> PayList(String o_username);

	public void CreatePayment(KakaoApproval approval);

	public List<KaKaoReady> SelectPaymenet(String today);

	public void CreateCard(KakaoCardInfo cardInfo);

	public void CreateAmount(KakaoAmount amount);

}
