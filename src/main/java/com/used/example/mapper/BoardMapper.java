package com.used.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.used.example.domain.Board;
import com.used.example.domain.Product;


@Mapper
public interface BoardMapper {


	public void createBoard(Board board);


}
