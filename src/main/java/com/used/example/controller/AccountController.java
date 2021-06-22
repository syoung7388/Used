package com.used.example.controller;


import java.nio.charset.Charset;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import com.used.example.domain.AccountList;
import com.used.example.domain.AccountInfo;
import com.used.example.service.AccountService;



@CrossOrigin(origins="*", maxAge = 3600)
@RestController
@RequestMapping("api/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	private static final String Host ="https://opendart.fss.or.kr/api/fnlttSinglAcntAll.json";
	@Scheduled(cron="0 0 0 18 5 ?")
	public  ResponseEntity<?> getFinancialData() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders  headers = new HttpHeaders();
		headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));	
		UriComponents  builder = UriComponentsBuilder.fromHttpUrl(Host)
				.queryParam("crtfc_key", "e389c515c006192713568d140ad80d7ccba2086a")
				.queryParam("corp_code", "00126380")
				.queryParam("bsns_year", "2020")
				.queryParam("reprt_code", "11011")
				.queryParam("fs_div", "OFS")
				.build(false);
		ResponseEntity<AccountList> account = 
				restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<String>(headers), new ParameterizedTypeReference<AccountList>() {});
		AccountList accountlist = account.getBody();
		accountService.FinancialData(accountlist);
		return new ResponseEntity<>(HttpStatus.OK);	
	}
	
	
	@GetMapping
	public ResponseEntity<?> getAccountInfo(){

		AccountInfo accountinfo = accountService.getAccountInfo();
				
		return new ResponseEntity<>(accountinfo, HttpStatus.OK);
		
		
	}
	

}
