package com.used.example.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.used.example.config.JwtUtils;
import com.used.example.domain.Auction;
import com.used.example.domain.Pagination;
import com.used.example.domain.User;
import com.used.example.response.JwtResponse;
import com.used.example.service.AuctionService;
import com.used.example.service.UserService;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/all")
public class AllController {
	
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
    
    
    @Autowired
    UserService userService;
    
    
    @Autowired
    AuctionService auctionService;
    
    @Autowired
    JwtUtils jwtUtils;
    
    @Autowired
    AuthenticationManager authenticationManager;
    

 
    
    

	@PostMapping("/sms")
	public ResponseEntity<?> sendSMS(@RequestBody User user ) {
		
		String phoneNumber= user.getPhone();
		Random rand= new Random();
		String numStr="";
		for(int i=0; i<4; i++) {
			String ran= Integer.toString(rand.nextInt(10));
			numStr += ran;
		}
		
		System.out.println("폰번호:"+ phoneNumber);
		System.out.println("인증번호:"+numStr);
		user.setNumStr(numStr);
		
		String text = "Used 인증 번호는 ["+ numStr + "]입니다.";
		
		String api_key= "NCS5GW8B7QDXQERY";
		String api_secret="FBJNABLR68IVRK5LM5JTBIP5MUMK9AVA";
		Message coolsms= new Message(api_key, api_secret);
		HashMap<String, String> params= new HashMap<String, String>();
		params.put("to", phoneNumber);
		params.put("from", "01083747388");
		params.put("type", "SMS");
		params.put("text", text);
		params.put("app_version", "test app 1.2");
		
		try {
			JSONObject obj= (JSONObject)coolsms.send(params);
			System.out.println(obj.toString());
		}catch (CoolsmsException e) {
            System.out.println("문자인증오류:"+e.getMessage());
            System.out.println("문자인증오류:"+e.getCode());
		}
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	

	@PostMapping("/signup")
	public ResponseEntity<?> Signup(@RequestBody User user){
		
		Map<String, Integer> check = new HashMap<>();
		check = userService.Check(user);
		int check_username = Integer.parseInt( String.valueOf(check.get("check_username")));
		int check_name = Integer.parseInt( String.valueOf(check.get("check_name")));
		if(check_username == 1 || check_name== 1) {
			
			return new ResponseEntity<>(check, HttpStatus.OK);
		
		}else {
			
			userService.SignUp(user);
		return new ResponseEntity<>("success", HttpStatus.OK);
		}
		
	}

	
	
	@PostMapping("/login")
	public ResponseEntity<?> Login(@RequestBody User user){
		logger.info("넘어온 값" +user);
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())); 
	
		SecurityContextHolder.getContext().setAuthentication(authentication);  

	
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		user= (User) authentication.getPrincipal();
		logger.info("authentication.getPrincipal():"+ authentication.getPrincipal());
		
		List<String> roles= user.getAuthorities().stream()
								.map(item -> item.getAuthority())
								.collect(Collectors.toList());
	    jwt="Bearer"+jwt;

		return ResponseEntity.ok(new JwtResponse(jwt,
													user.getUsername(),
													user.getName(),
													roles));
	}
	
	
	
	@GetMapping("/top")
	public ResponseEntity<?> TopList(@RequestParam("lat") String lat, @RequestParam("lon") String lon, @RequestParam("page") int page, HttpServletRequest request){
		
		logger.info("=============================================================");
		Map<String, Object> map = new HashMap<>();
		Pagination pagination = new Pagination();
		
		map.put("lat", lat);
		map.put("lon", lon);
		map.put("limit", page*pagination.getPerpage());
		map.put("page", page);
		
		Map<String, Object> topmap = auctionService.TopList(map);
		
		return new ResponseEntity<>( topmap, HttpStatus.OK);
		
	}
	
	@GetMapping("/industry")
	public ResponseEntity<?> IndustryList(@RequestParam("lat")String lat, @RequestParam("lon")String lon, @RequestParam("industry")String industry, @RequestParam("page") int page, HttpServletRequest request){
		
		
		Pagination pagination = new Pagination();
		Map<String ,Object> map = new HashMap<>();
		map.put("lat", lat);
		map.put("lon", lon);
		map.put("industry", industry);
		map.put("page", page);
		map.put("limit", page*pagination.getPerpage());
		
		
		Map<String ,Object> industrymap = auctionService.IndustryList(map);

		return new ResponseEntity<>(industrymap, HttpStatus.OK);
	
	}
	
	@GetMapping("/kind")
	public ResponseEntity<?> KindList(@RequestParam("lat")String lat, @RequestParam("lon")String lon, @RequestParam("kind")String kind ,@RequestParam("page") int page , HttpServletRequest request){
		Pagination pagination = new Pagination();
		Map<String ,Object> map = new HashMap<>();
		map.put("lat", lat);
		map.put("lon", lon);
		map.put("kind", kind);
		map.put("limit", page*pagination.getPerpage());
		map.put("page", page);

		Map<String ,Object> kindmap = auctionService.KindList(map);


		return new ResponseEntity<>(kindmap, HttpStatus.OK);
	
	}
	@GetMapping("/{a_num}")
	public ResponseEntity<?> AucDetail(@PathVariable("a_num") int a_num){
		
		auctionService.Hits(a_num);
		Auction auction= auctionService.AucDetail(a_num);
			
		return new ResponseEntity<>(auction, HttpStatus.OK);
			
	
		
	}
	
	
	
	

}
