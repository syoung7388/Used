package com.used.example.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	public ResponseEntity<?> Writing (@RequestBody Board board, Product product){
		
		
		
		
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
		User user = (User)principal; 
		String username = ((User) principal).getUsername(); 
		String password = ((User) principal).getPassword();
		
		logger.info("username:"+username);
		
		

		
		
		

//		String username= user.getUsername();	
//		board.setWriter(username);
		
		
		int selectBnum= boardService.createBoard(board);
		product.setB_number(selectBnum);
		
		
		
		
		
		
		productService.createProduct(product);
		
		
		
		
		
		
		
			return new ResponseEntity<>("success", HttpStatus.OK);
		

		
		
	}
	
	

}
