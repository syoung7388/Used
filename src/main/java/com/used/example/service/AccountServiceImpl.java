package com.used.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.used.example.domain.AccountInfo;
import com.used.example.domain.AccountList;
import com.used.example.mapper.AccountMapper;




@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountMapper accountMapper;


	@Override
	public AccountInfo getAccountInfo() {
		return accountMapper.getAccountInfo();
	}
	
	
	@Async
	@Override
	public void FinancialData(AccountList accountlist) {
	
		
		accountMapper.SaveAccountRate();
	
		
		
	}

}
