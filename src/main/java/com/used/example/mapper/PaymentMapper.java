package com.used.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.used.example.domain.Product;

@Mapper
public interface PaymentMapper {

	public Product PaymentDetail(int p_num);

}
