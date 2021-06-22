package com.used.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Auction;
import com.used.example.domain.Like;
import com.used.example.domain.Product;
import com.used.example.mapper.AuctionMapper;
import com.used.example.mapper.LikeMapper;



@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	LikeMapper likeMapper;
	
	@Autowired
	AuctionMapper auctionMapper; 

	@Override
	public Auction CreateLike(Like like) {
		likeMapper.CreateLike(like);
		
		int a_num= like.getA_num();
		Auction auction= auctionMapper.AucDetail(a_num);
		return auction;
		
	}


	@Override
	public Auction DeleteLike(String l_username, int a_num) {
		Like like = new Like();
		like.setA_num(a_num);
		like.setL_username(l_username);
		likeMapper.DeleteLike(like);
		Auction auction= auctionMapper.AucDetail(a_num);
		return auction;
	}


	@Override
	public List<Auction> LikeList(String l_username) {
		return likeMapper.LikeList(l_username);
	}

}
