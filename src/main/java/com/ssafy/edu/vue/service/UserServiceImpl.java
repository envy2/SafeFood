package com.ssafy.edu.vue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.SSAFyDaoImpl;
import com.ssafy.edu.vue.dto.UserDto;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private SSAFyDaoImpl userdao;
	
	@Override
	@Transactional
	public void insertUser(UserDto user) throws Exception {
		userdao.insertUser(user);
	}

	@Override
	@Transactional(readOnly=true)
	public UserDto login(UserDto user) throws Exception {
		return userdao.login(user);
	}

	@Override
	@Transactional
	public void updateUser(UserDto user) throws Exception {
		userdao.updateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(String id) throws Exception {
		userdao.deleteUser(id);
	}

	@Override
	public UserDto findPassword(UserDto user) throws Exception {
		return userdao.findPassword(user);
	}

	@Override
	public UserDto findId(UserDto user) throws Exception {
		return userdao.findId(user);
	}

	@Override
	public UserDto findName(UserDto user) throws Exception {
		return userdao.findName(user);
	}

}
