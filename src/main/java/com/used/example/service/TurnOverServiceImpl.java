package com.used.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.TurnOver;
import com.used.example.mapper.TurnOverMapper;



@Service
public class TurnOverServiceImpl implements TurnOverService{
	
	
	
	@Autowired
	TurnOverMapper turnoverMapper;

	@Override
	public List<TurnOver> getTurnOverInfo(String year) {
		
		return turnoverMapper.getTurnOverInfo(year);
		
	}
	
	

}
