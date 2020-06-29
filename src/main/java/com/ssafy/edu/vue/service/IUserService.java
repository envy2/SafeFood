package com.ssafy.edu.vue.service;

import com.ssafy.edu.vue.dto.UserDto;

public interface IUserService {
	public void insertUser(UserDto user) throws Exception; 
	public UserDto login(UserDto user) throws Exception;
	public void updateUser(UserDto user) throws Exception;
	public void deleteUser(String id) throws Exception;
	public UserDto findPassword(UserDto user) throws Exception;
	public UserDto findId(UserDto user) throws Exception;
	public UserDto findName(UserDto user) throws Exception;
}
