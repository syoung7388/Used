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
	public Auction DeleteLike(int a_num) {
		likeMapper.DeleteLike(a_num);
		Auction auction= auctionMapper.AucDetail(a_num);
		return auction;
	}


	@Override
	public List<Auction> LikeList(String l_username) {
		return likeMapper.LikeList(l_username);
	}

}
