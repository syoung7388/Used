package com.used.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.used.example.domain.Auction;
import com.used.example.domain.Payment;
import com.used.example.domain.Product;

@Mapper
public interface PaymentMapper {

	public Product PaymentDetail(int p_num);

	public List<Auction> PayList(String o_username);

	public void CreatePayment(List<Payment> list);

	public List<Payment> SelectPaymenet(String today);

}
