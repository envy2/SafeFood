package com.ssafy.edu.vue.service;

import java.util.List;

import com.ssafy.edu.vue.dto.BoardDto;
import com.ssafy.edu.vue.dto.PageBoardDto;

public interface IBoardService {
	public void addBoard(BoardDto board) throws Exception;
	public List<BoardDto> boardAllLists() throws Exception;
	public void deleteBoard(int no) throws Exception;
	public void updateBoard(BoardDto board) throws Exception;
	public BoardDto findBoardByNo(int no) throws Exception;
	public void updateReadCount(int no) throws Exception;
	
	public int getBoardsTotal() throws Exception;
	public List<BoardDto> findAllBoardByPage(PageBoardDto pbean) throws Exception;

}
