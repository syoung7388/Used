package com.used.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.used.example.domain.Product;


@Mapper
public interface ProductMapper {
	
	
	public void createProduct(Product product);

}
