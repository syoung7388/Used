package com.used.example.service;

import org.springframework.http.ResponseEntity;

import com.used.example.domain.AccountList;

public interface AccountService {

	public void SaveAccount(AccountList accountlist);

}
