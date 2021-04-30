package com.used.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Auction;
import com.used.example.domain.Like;
import com.used.example.domain.Product;
import com.used.example.mapper.LikeMapper;



@Service
public class LikeServiceImpl implements LikeService {
	
	@Autowired
	LikeMapper likeMapper;


	@Override
	public void CreateLike(Like like) {
		likeMapper.CreateLike(like);
		
	}


	@Override
	public void DeleteLike(int a_num) {
		likeMapper.DeleteLike(a_num);
		
	}


	@Override
	public List<Auction> LikeList(String l_username) {
		return likeMapper.LikeList(l_username);
	}

}
