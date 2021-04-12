package com.used.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.used.example.domain.Picture;
import com.used.example.domain.Product;


@Mapper
public interface ProductMapper {
	
	
	public void createProduct(Product product);

	public void createPicture(Picture picture);

	public List<Product> getSaleList(String username);

	public List<String> getImg(int i);



}
