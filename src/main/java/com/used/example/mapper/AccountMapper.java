package com.used.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.used.example.domain.AccountInfo;
import com.used.example.domain.AccountList;

@Mapper
public interface AccountMapper {

	public void SaveAccount(AccountList accountlist);

	public AccountInfo getAccountInfo();

	public void SaveAccountRate();

}
