package com.used.example.service;

import java.util.List;

import com.used.example.domain.Like;
import com.used.example.domain.Product;

public interface LikeService {

	public void CreateLike(Like like);

	public void DeleteLike(Like like);

	public List<Product> LikeList(String l_username);

}
