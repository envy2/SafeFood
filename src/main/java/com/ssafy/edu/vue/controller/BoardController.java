package com.ssafy.edu.vue.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.edu.vue.dto.BoardDto;
import com.ssafy.edu.vue.dto.PageBoardDto;
import com.ssafy.edu.vue.help.BoolResult;
import com.ssafy.edu.vue.help.NumberResult;
import com.ssafy.edu.vue.service.IBoardService;
import com.ssafy.edu.vue.service.IFoodService;

import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value="SSAFY", description="SSAFY Resouces Management 2019")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private IBoardService iBoardService;
	
	@ApiOperation(value = "모든 게시글의 정보를 반환한다.", response = List.class)
	@RequestMapping(value = "/boardAllLists", method = RequestMethod.GET)
	public ResponseEntity<List<BoardDto>> boardAllLists() throws Exception {
		logger.info("1-------------boardAllLists-----------------------------"+new Date());
		List<BoardDto> boards = iBoardService.boardAllLists();
		if (boards.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BoardDto>>(boards, HttpStatus.OK);
	}
	
	@ApiOperation(value = " 새로운 게시글을 입력한다.", response = NumberResult.class)
   	@RequestMapping(value = "/addBoard", method = RequestMethod.POST)
   	public void addBoard(@RequestBody BoardDto board) throws Exception {
   		logger.info("5-------------addBoard-----------------------------"+new Date());
   		iBoardService.addBoard(board);
   		
   	}
	
	@ApiOperation(value = " 게시글을 수정한다. ", response = BoolResult.class)
   	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
   	public void updateEmployee(@RequestBody BoardDto board) throws Exception {
   		logger.info("1-------------updateBoard-----------------------------"+new Date());
   		iBoardService.updateBoard(board);
   	}
	
	@ApiOperation(value = " 게시글을 삭제한다. ", response = BoolResult.class)
	@RequestMapping(value = "/deleteBoard/{no}", method = RequestMethod.POST)
	public void deleteBoard(@PathVariable int no) throws Exception {
		logger.info("1-------------deleteBoard-----------------------------"+new Date());
		iBoardService.deleteBoard(no);
	}
	
	@ApiOperation(value = "게시글의 번호로 상세보기", response = BoardDto.class)
	@RequestMapping(value = "/findBoardByNo/{no}", method = RequestMethod.GET)
	public ResponseEntity<BoardDto> findBoardByNo(@PathVariable int no) throws Exception {
		logger.info("1-------------findBoardByNo-----------------------------"+new Date());
		BoardDto board = iBoardService.findBoardByNo(no);
		iBoardService.updateReadCount(no);
		return new ResponseEntity<BoardDto>(board, HttpStatus.OK);
	}
/*-----------------------------------------PAGING---------------------------------------------------------------*/	
	
	@ApiOperation(value = "페이지에 해당하는 게시판 정보를 반환한다.", response = PageBoardDto.class)
	@RequestMapping(value = "/findAllBoardByPage/{curpage}/{perpage}", method = RequestMethod.GET)
	public ResponseEntity<PageBoardDto> findAllBoardByPage(
			@PathVariable int curpage,	
			@PathVariable int perpage ) throws Exception {
		logger.info("3-------------findAllBoardByPage-----------------------------"+new Date());
		
		PageBoardDto pbean=new PageBoardDto();
		pbean.setCurpage(curpage);
		pbean.setPerpage(perpage);
		int totalline=iBoardService.getBoardsTotal();
		pbean.setTotalline(totalline);
		int startpage=pbean.getStartpage();
		
		logger.info("3-------------findLikeEmployees-----------------------------"+startpage);
		List<BoardDto> boards = iBoardService.findAllBoardByPage(pbean);
		pbean.setEmps(boards);
		
		if (boards.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<PageBoardDto>(pbean, HttpStatus.OK);

	}
}
