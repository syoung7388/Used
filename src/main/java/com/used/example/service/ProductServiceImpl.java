package com.used.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Product;
import com.used.example.mapper.ProductMapper;


@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	ProductMapper productMapper;
	
	@Override
	public void createProduct(Product product) {
		productMapper.createProduct(product);
		
	}

}
