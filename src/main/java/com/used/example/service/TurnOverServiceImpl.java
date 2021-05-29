package com.used.example.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.date.DateForm;
import com.used.example.domain.TurnOver;
import com.used.example.mapper.TurnOverMapper;



@Service
public class TurnOverServiceImpl implements TurnOverService{
	
	
	
	@Autowired
	TurnOverMapper turnoverMapper;
	@Autowired
	DateForm dateForm;

	@Override
	public Map<String, Object> getTurnOverInfo() {
		
		

		String year = dateForm.getYear();
		
		
		List<TurnOver> list = turnoverMapper.getTurnOverInfo(year);
		List<String> month = new ArrayList<>();
		List<Long> amount = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			month.add(list.get(i).getMonth() +"월");
			amount.add(list.get(i).getAmount());
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("month", month);
		map.put("amount", amount);
		
		return map;
		
	}
	
	

}
