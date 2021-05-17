package com.used.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.used.example.domain.TurnOver;

@Mapper
public interface TurnOverMapper {

	public List<TurnOver> getTurnOverInfo(String year);

}
