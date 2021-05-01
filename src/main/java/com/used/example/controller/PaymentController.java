package com.used.example.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.used.example.config.JwtUtils;
import com.used.example.domain.Auction;
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
	
	
	
	
	
	@PostMapping
	@ResponseBody
	public String KakaoPay(@RequestBody Auction auction){
		//logger.info("auction:"+auction);
		
		
		Product product= auction.getProduct().get(0);
		Offer offer = auction.getOffer().get(0);

		
		
		try {
			
		
			URL url= new URL("https://kapi.kakao.com/v1/payment/ready");
			HttpURLConnection connection= (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", "KakaoAK 7824d85f0892e82e54e73144138aba0a" );
			connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			connection.setDoOutput(true);
			
			StringBuilder parameter = new StringBuilder();
			parameter.append("cid="+"TC0ONETIME");
			parameter.append("&partner_order_id="+offer.getA_num());
			parameter.append("&partner_user_id="+offer.getO_username());
			parameter.append("&item_name="+product.getKind());
			parameter.append("&item_code="+product.getP_num());
			parameter.append("&quantity=1");
			parameter.append("&total_amount="+offer.getPrice());
			parameter.append("&tax_free_amount=0");
			parameter.append("&approval_url=http://localhost:8080/payready");
			parameter.append("&cancel_url=http://localhost:8080/payready");
			parameter.append("&fail_url=http://localhost:8080/payready");
			
			String param = parameter.toString();
			logger.info("param:"+param);
			
			
			OutputStream output = connection.getOutputStream();
			DataOutputStream doutput = new DataOutputStream(output);
			doutput.writeBytes(param);
			doutput.close();
			
			int result = connection.getResponseCode();
			logger.info("result:"+result);
			
			InputStream input;
			if(result == 200) {
				input = connection.getInputStream();
			}else {
				input = connection.getErrorStream();
			}
			
			
			InputStreamReader reader = new InputStreamReader(input);
			BufferedReader breader = new BufferedReader(reader);
			

			return breader.readLine();
			
	}catch(MalformedURLException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
		
		return "err";
		
		
		
	}
	
	
	@GetMapping("/success")
	public void Suc(@RequestParam("pg_token") String pg_token) {
		logger.info("approval");
		logger.info("pg_token"+pg_token);

		
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	


}
