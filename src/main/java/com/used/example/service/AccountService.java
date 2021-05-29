package com.used.example.service;

import org.springframework.http.ResponseEntity;

import com.used.example.domain.AccountInfo;
import com.used.example.domain.AccountList;

public interface AccountService {


	public AccountInfo getAccountInfo();

	public void FinancialData(AccountList accountlist);

}
