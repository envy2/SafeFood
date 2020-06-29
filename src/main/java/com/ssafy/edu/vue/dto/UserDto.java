package com.ssafy.edu.vue.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String alr;
	
	public UserDto() {
		super();
	}

	
	public UserDto(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}


	public UserDto(String id, String pwd, String name, String phone, String alr) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.alr = alr;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAlr() {
		return alr;
	}


	public void setAlr(String alr) {
		this.alr = alr;
	}


	@Override
	public String toString() {
		return "UserDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + ", alr=" + alr + "]";
	}
	
	
	
	
	
}
