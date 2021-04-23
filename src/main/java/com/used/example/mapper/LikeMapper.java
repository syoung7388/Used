package com.used.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.used.example.domain.Like;

@Mapper
public interface LikeMapper {

	public void CreateLike(Like like);

	public void DeleteLike(Like like);

}
