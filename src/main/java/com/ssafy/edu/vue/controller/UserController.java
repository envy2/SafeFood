package com.ssafy.edu.vue.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.ssafy.edu.vue.dto.UserDto;
import com.ssafy.edu.vue.help.BoolResult;
import com.ssafy.edu.vue.help.NumberResult;
import com.ssafy.edu.vue.service.IUserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value="SSAFY", description="SSAFY Resouces Management 2019")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService iUserService;

	@ApiOperation(value = "새로운 회원을 등록한다.", response = NumberResult.class)
   	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
   	public ResponseEntity<NumberResult> insertUser(@RequestBody UserDto user) throws Exception {
   		logger.info("5-------------insertUser-----------------------------"+new Date());
   		logger.info("5-------------insertUser-----------------------------"+user.getAlr());
   		NumberResult nr=new NumberResult();
   		if(user.getId() == null || user.getId() =="") {
   			nr.setState("아이디를 입력 하세요.");
   		}
   		else if(user.getPwd() == null || user.getPwd() =="") {
   			nr.setState("비밀번호를 입력 하세요.");
   		}
   		else if(user.getName() == null || user.getName() == "") {
   			nr.setState("닉네임을 입력 하세요.");
   		}
   		else if(user.getPhone() == null || user.getPhone() == "") {
   			nr.setState("전화번호를 입력하세요.");
   		}
   		else {
   			if(iUserService.findId(user) != null) {
   	   			nr.setState("이미 존재하는 아이디 입니다.");
   	   		}
   	   		else if(iUserService.findName(user) != null) {
   	   			nr.setState("이미 존재하는 닉네임 입니다.");
   	   		}
   	   		else {
   	   			iUserService.insertUser(user);
   	   		nr.setState("회원가입에 성공하였습니다.");
   	   		}
   		}
   		
   		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   	}

//	//login
//	@ApiOperation(value = "로그인", response = UserDto.class)
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ResponseEntity<UserDto> login(@RequestBody UserDto user) throws Exception {
//		logger.info("1-------------login-----------------------------"+new Date());
//		UserDto users = iUserService.login(user);
//		if (users==null || users.getId().equals("")) {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
//
//		return new ResponseEntity<UserDto>(users, HttpStatus.OK);
//	}
	
	@ApiOperation(value = "회원정보를 수정한다.", response = BoolResult.class)
   	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
   	public ResponseEntity<NumberResult> updateUser(@RequestBody UserDto user) throws Exception {
   		logger.info("1-------------updateUser-----------------------------"+new Date());
   		iUserService.updateUser(user);
   		NumberResult nr=new NumberResult();
   		nr.setState("succ");
   		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
   	}
    @ApiOperation(value = "회원을 삭제한다", response = BoolResult.class)
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public void deleteUser(@PathVariable String id) throws Exception {
		logger.info("1-------------deleteUser-----------------------------"+new Date());
		logger.info("1-------------deleteUser-----------------------------"+id);
		
		iUserService.deleteUser(id);
	}
    
    @ApiOperation(value = "패스워드 찾기", response = UserDto.class)
	@RequestMapping(value = "/findPassword", method = RequestMethod.POST)
	public ResponseEntity<UserDto> findPassword(@RequestBody UserDto user) throws Exception {
		logger.info("1-------------findPassword-----------------------------"+new Date());
		logger.info("1-------------findPassword-----------------------------"+user);
		UserDto users = iUserService.findPassword(user);
		if (users==null || users.getId().equals("")) {
			logger.info("1-------------findPassword-----------------------------FAIL");
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		logger.info("1-------------findPassword-----------------------------"+users);
		return new ResponseEntity<UserDto>(users, HttpStatus.OK);
	}
}
