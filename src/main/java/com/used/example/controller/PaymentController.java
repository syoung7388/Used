package com.used.example.controller;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;

import com.used.example.domain.Amount;

import com.used.example.domain.Card;
import com.used.example.domain.KakaoReady_R;

import com.used.example.domain.Payment;
import com.used.example.domain.KaKaoReady;

import com.used.example.domain.KakaoApproval;

import com.used.example.service.AuctionService;
import com.used.example.service.ChatService;
import com.used.example.service.PaymentService;
import com.used.example.service.ProcessService;


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
	
	@Autowired
	ProcessService processService;
	
	@Autowired
	ChatService chatService;
	
	private static final String HOST = "https://kapi.kakao.com";
	private KakaoApproval approval;
	
	private int a_num;
	

	
	
	
	
	@Secured({"ROLE_USER"})
	@PostMapping("/kready")
	@ResponseBody
	public ResponseEntity<?> KaKaoReady(@RequestBody KaKaoReady kakao, HttpServletRequest request){


        RestTemplate restTemplate = new RestTemplate();
 
        
        HttpHeaders headers = new HttpHeaders();
        //headers.add("Authorization", "KakaoAK " + "7824d85f0892e82e54e73144138aba0a");
        headers.add("Authorization", "KakaoAK " + "0a8b37524752c3a783b36257cfe92e4d");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
      
        
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("partner_order_id", Integer.toString(kakao.getA_num()));
        params.add("partner_user_id", kakao.getO_username());
        params.add("item_code", Integer.toString(kakao.getP_num()));
 
        params.add("item_name", kakao.getKind());
        params.add("quantity", "1");
        params.add("total_amount", Long.toString(kakao.getPrice()));
        params.add("tax_free_amount", "0");
      params.add("approval_url", "http://192.168.1.46:8080");
      params.add("cancel_url", "http://192.168.1.46:8080");
      params.add("fail_url", "http://192.168.1.46:8080");
        
  
        
        
        
        
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        
        try {
        	
        	KakaoReady_R res= restTemplate.postForObject(new URI(HOST + "/v1/payment/ready"), body, KakaoReady_R.class);  	
        	kakao.setKready_r(res);
        	logger.info("payment: "+kakao);
        	return new ResponseEntity<>( kakao, HttpStatus.OK);
        	
        }catch(URISyntaxException e) {
        	e.printStackTrace();
        }

		return new ResponseEntity<>( HttpStatus.OK);
		
		
		
	}
	
	
	
	@Secured({"ROLE_USER"})
	@PostMapping("/kapproval")
	@ResponseBody
	public ResponseEntity<?> KaKaoApproval(@RequestBody KaKaoReady ready, HttpServletRequest request) {
		
		
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK " + "7824d85f0892e82e54e73144138aba0a");
        headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("cid", "TC0ONETIME");
        params.add("tid", ready.getKready_r().getTid());
        params.add("partner_order_id", Integer.toString(ready.getA_num()));
        params.add("partner_user_id", ready.getO_username());
        params.add("pg_token", ready.getKready_r().getK_token());
        params.add("total_amount", Long.toString(ready.getPrice()));      
        HttpEntity<MultiValueMap<String, String>> body = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        try {
      
            approval = restTemplate.postForObject(new URI(HOST + "/v1/payment/approve"), body, KakaoApproval.class);
            logger.info("" + approval);
   
            Payment payment = new Payment();
            payment.setA_num(approval.getPartner_order_id());
            payment.setCop("KAKAOPAY");
            payment.setKind(approval.getItem_name());
            payment.setMethod(approval.getPayment_method_type());
            payment.setP_num(approval.getItem_code());
            payment.setPa_username(approval.getPartner_user_id());
            payment.setQuantity(approval.getQuantity());
            payment.setPatime(approval.getApproved_at());
            logger.info(""+payment);
            paymentService.CreatePayment(payment);
           
            int pa_num= payment.getPa_num();
            
            
            
            if(approval.getCard_info() != null) {
            
            	Card card = new Card();
            	card.setBin(approval.getCard_info().getBin());
            	card.setInstall_month(approval.getCard_info().getInstall_month());
            	card.setInterest_free_install(approval.getCard_info().getInterest_free_install());
            	card.setType(approval.getCard_info().getCard_type());
            	card.setApproved_id(approval.getCard_info().getApproved_id());
            	card.setPa_num(pa_num);
            	card.setMid(approval.getCard_info().getCard_mid());
            	
            	paymentService.CreateCard(card);
            	
            }
           
            Amount amount = new Amount();
            amount.setPa_num(pa_num);
            amount.setDiscount(approval.getAmount().getDiscount());
            amount.setPoint(approval.getAmount().getPoint());
            amount.setTax_free(approval.getAmount().getTax_free());
            amount.setTotal(approval.getAmount().getTotal());
            amount.setVat(approval.getAmount().getVat());
            paymentService.CreateAmount(amount);
            
            a_num = payment.getA_num();
   
        } catch (RestClientException e) {
         
            e.printStackTrace();
        } catch (URISyntaxException e) {
            
            e.printStackTrace();
        }
        
        paymentService.ProcessUp(a_num);
        Map<String, Object> map= paymentService.PaymentDetail(a_num);
        
        return new ResponseEntity<>(map, HttpStatus.OK);
        
    
	}
	
	
	
	@Secured({"ROLE_USER"})
	@GetMapping("/{a_num}")
	public ResponseEntity<?> PaymentDetail(@PathVariable("a_num") int a_num, HttpServletRequest request){
		
		
		Map<String, Object> map = paymentService.PaymentDetail(a_num);
		return new ResponseEntity<>(map , HttpStatus.OK);
		
		
	}
	
	
	
	


}
