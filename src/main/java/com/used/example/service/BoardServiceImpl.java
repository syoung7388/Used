package com.used.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.used.example.domain.Board;
import com.used.example.domain.Product;
import com.used.example.mapper.BoardMapper;



@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper boardMapper;

	@Override
	public int createBoard(Board board) {
		return boardMapper.createBoard(board);
		
	}


	

}
