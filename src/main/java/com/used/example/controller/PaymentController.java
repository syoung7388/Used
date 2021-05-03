package com.used.example.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.used.example.config.JwtUtils;
import com.used.example.domain.Auction;
import com.used.example.domain.KakaoPay_res;
import com.used.example.domain.Offer;
import com.used.example.domain.Payment;
import com.used.example.domain.Product;
import com.used.example.service.AuctionService;
import com.used.example.service.PaymentService;


@CrossOrigin(origins="*", maxAge= 3600)
@RestController
@RequestMapping("api/payment")
public class PaymentController {
	
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String token;
	
	
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	AuctionService auctionService;
	
	private static final String HOST = "https://kapi.kakao.com";
	
	
	
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<?> KakaoPay(@RequestBody Payment payment){
		//logger.info("auction:"+auction);
		

        RestTemplate restTemplate = new RestTemplate();
 
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "7824d85f0892e82e54e73144138aba0a");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
      
        
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", Integer.toString(payment.getA_num()));
        params.add("partner_user_id", payment.getO_username());
        params.add("item_name", payment.getKind());
        params.add("quantity", "1");
        params.add("total_amount", Long.toString(payment.getPrice()));
        params.add("tax_free_amount", "0");
        params.add("approval_url", "http://localhost:8080/payapproval");
        params.add("cancel_url", "http://localhost:8080/payapproval");
        params.add("fail_url", "http://localhost:8080/payapproval");
        
        
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        
        
        
        
        try {
        	KakaoPay_res res= restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoPay_res.class);
        	
        	payment.setRes(res);
        	
        
        	
        	logger.info("payment: "+payment);
        	return new ResponseEntity<>( payment, HttpStatus.OK);
        	
        }catch(URISyntaxException e) {
        	e.printStackTrace();
        }
		


		
	
		
		return new ResponseEntity<>( HttpStatus.OK);
		
		
		
	}
	@PostMapping("/approval")
	public ResponseEntity<?> ApprovalDetail(@RequestBody Payment payment){
		
		
		logger.info("payment"+ payment);
		return new ResponseEntity<>("success", HttpStatus.OK);
		
	}
	
	

	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	


}
