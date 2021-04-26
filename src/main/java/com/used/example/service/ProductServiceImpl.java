package com.used.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.used.example.domain.Auction;
import com.used.example.domain.Picture;
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

	@Override
	public void createPicture(Picture picture) {
		productMapper.createPicture(picture);
		
	}

	@Override
	public List<Product> getSaleList(String username) {
		return productMapper.getSaleList(username);
	}

	@Override
	public List<String> getImg(int i) {
		return productMapper.getImg(i);
	}

	@Override
	public List<Product> getSoldList(String username) {
		
		return productMapper.getSoldList(username);
	}

	@Override
	public Product ProductDetail(Product product) {
		return productMapper.ProductDetail(product);
	}

	@Override
	public List<Auction> getAuction(int p_num) {
		
		return productMapper.getAuction(p_num);
	}

	@Override
	public void updateProduct(Product product) {
		productMapper.updateProduct(product);
		
	}

	@Override
	public void deletePicture(Picture picture) {
		productMapper.deletePicture(picture);
		
	}

	@Override
	public void deleteProduct(int p_num) {
		productMapper.deleteProduct(p_num);
		
	}

	@Override
	public List<Product> TopList(Product product) {
		return productMapper.TopList(product);
		
	}

	@Override
	public List<Product> IndustryList(Product product) {
		return productMapper.IndustryList(product);
	}

	@Override
	public List<Product> KindList(Product product) {
		
		return productMapper.KindList(product);
	}

	








}
