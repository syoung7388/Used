package com.used.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.used.example.domain.Auction;
import com.used.example.domain.Like;
import com.used.example.domain.Product;

@Mapper
public interface LikeMapper {

	public void CreateLike(Like like);

	public void DeleteLike(Like like);

	public List<Auction> LikeList(String l_username);

}
