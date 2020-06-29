package com.ssafy.edu.vue.dto;


public class EatDto {
	private String id;
	private int code;
	private String name;
	private int number;
	
	

	public EatDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public EatDto(String id, int code) {
		super();
		this.id = id;
		this.code = code;
	}

	public EatDto(String id, int code, int number) {
		super();
		this.id = id;
		this.code = code;
		this.number = number;
	}


	public EatDto(String id, int code, String name, int number) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.number = number;
	}

	

	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	@Override
	public String toString() {
		return "EatDto [id=" + id + ", code=" + code + ", name=" + name + ", number=" + number + "]";
	}



	
	
}
