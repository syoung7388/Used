package com.used.example.service;

import java.util.List;

import com.used.example.domain.Auction;
import com.used.example.domain.Picture;
import com.used.example.domain.Product;

public interface ProductService {
	
	public void createProduct(Product product);

	public void createPicture(Picture picture);

	public List<Product> getSaleList(String username);

	public List<String> getImg(int i);

	public List<Product> getSoldList(String username);

	public Product getSaleDetail(int p_num);

	public List<Auction> getAuction(int p_num);

	public void updateProduct(Product product);

	public void deletePicture(Picture picture);

	

}
