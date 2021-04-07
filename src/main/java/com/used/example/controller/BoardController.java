package com.used.example.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.used.example.domain.Board;
import com.used.example.domain.Product;
import com.used.example.domain.User;
import com.used.example.service.BoardService;
import com.used.example.service.ProductService;

@CrossOrigin(origins="*", maxAge =3600)
@RestController
@RequestMapping("/api/board")
public class BoardController {
	
	
	@Autowired 
	BoardService boardService;
	
	
	@Autowired
	ProductService productService;
	
	private final Logger logger= LoggerFactory.getLogger(this.getClass());
	
	

	
	
	
	@PostMapping("/writing")
	public ResponseEntity<?> Writing (@RequestBody Board board){
		
		
		
// Q) 세션에 저장되어있는 username을 어떻게 꺼내오는가?계속 uknownuser라는 스트링 타입이 넘어온다          일단, vue에서 자체제작을 하기로 했다.. 
		
		
// 1. @AuthenticationPrincipal UserDetails userdetails ///logger.info("username:"+userdetails.getUsername());
//	2.	User user= (User) authentication.getPrincipal();
//		String user_id = user.getUsername();
//	3.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String username = authentication.getName(); 혹시 몰라서 getUsername 으로도 해봄
//		logger.debug("current username : {}", username);	
//		--> 안되는 이유? 1.Token을 계속 ? 2. 로그인할때 lodeby로 가져온 내용들이 세션에 저장이 되지 않았다. 3.컨트롤러가 달라서? 
			

//		String username= user.getUsername();	
//		board.setWriter(username);
		
	
		
		boardService.createBoard(board);
		
		Product product= board.getProduct();
		
		
		
		product.setB_number(board.getB_num());
		
		logger.info("b_number"+board.getB_num());
		
		logger.info("product"+product);
	
		
		productService.createProduct(product);
		
		
		
		
		
		
		
			return new ResponseEntity<>("success", HttpStatus.OK);
		

		
		
	}
	
	

}
