package com.used.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Like;
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
	public void DeleteLike(Like like) {
		likeMapper.DeleteLike(like);
		
	}

}
