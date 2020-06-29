package com.ssafy.edu.vue.dto;

import java.sql.Date;

public class IngestionDto {
	private String id;
	private int code;
	private String name;
	private int number;
	private String day;
	private String startday;
	private String endday;
	
	
	public IngestionDto() {
		super();
	}


	public IngestionDto(String id, int code, String name, int number, String day, String startday, String endday) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.number = number;
		this.day = day;
		this.startday = startday;
		this.endday = endday;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
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


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getStartday() {
		return startday;
	}


	public void setStartday(String startday) {
		this.startday = startday;
	}


	public String getEndday() {
		return endday;
	}


	public void setEndday(String endday) {
		this.endday = endday;
	}


	@Override
	public String toString() {
		return "IngestionDto [id=" + id + ", code=" + code + ", name=" + name + ", number=" + number + ", day=" + day
				+ ", startday=" + startday + ", endday=" + endday + "]";
	}
	
	
	
	
}
