package com.used.example.service;

import java.util.List;

import com.used.example.domain.Auction;
import com.used.example.domain.Like;
import com.used.example.domain.Product;

public interface LikeService {

	public void CreateLike(Like like);

	public void DeleteLike(int a_num);

	public List<Auction> LikeList(String l_username);

}
