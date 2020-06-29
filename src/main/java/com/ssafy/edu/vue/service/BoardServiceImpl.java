package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.SSAFyDaoImpl;
import com.ssafy.edu.vue.dto.BoardDto;
import com.ssafy.edu.vue.dto.PageBoardDto;

@Service
public class BoardServiceImpl implements IBoardService {
	
	@Autowired
	private SSAFyDaoImpl boarddao;
	
	@Override
	public void addBoard(BoardDto board) throws Exception {
		boarddao.addBoard(board);
	}

	@Override
	@Transactional(readOnly=true)
	public List<BoardDto> boardAllLists() throws Exception {
		return boarddao.boardAllLists();
	}

	@Override
	public void deleteBoard(int no) throws Exception {
		boarddao.deleteBoard(no);
	}

	@Override
	public void updateBoard(BoardDto board) throws Exception {
		boarddao.updateBoard(board);
	}

	@Override
	@Transactional(readOnly=true)
	public BoardDto findBoardByNo(int no) throws Exception {
		return boarddao.findBoardByNo(no);
	}
	
	@Override
	public void updateReadCount(int no) throws Exception {
		boarddao.updateReadCount(no);
	}

	@Override
	public int getBoardsTotal() throws Exception {
		// TODO Auto-generated method stub
		int total = boarddao.boardAllLists().size();
		return total;
	}

	@Override
	public List<BoardDto> findAllBoardByPage(PageBoardDto pbean) throws Exception {
		// TODO Auto-generated method stub
		return boarddao.findAllBoardByPage(pbean);
	}

}
