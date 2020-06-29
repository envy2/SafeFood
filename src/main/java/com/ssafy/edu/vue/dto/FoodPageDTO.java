package com.ssafy.edu.vue.dto;

import java.util.ArrayList;
import java.util.List;


public class FoodPageDTO {
	private int curpage=0;
	private int perpage=6;
	private int totalpage=0;
	private int startpage=0;
	private int totalline=0;
	
	private List<FoodDto> foods;
	
	public FoodPageDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public List<FoodDto> getEmps() {
		return foods;
	}
	public void setEmps(List<FoodDto> foods) {
		this.foods = foods;
	}
	
	@Override
	public String toString() {
		return "PageBoardDto [curpage=" + curpage + ", perpage=" + perpage + ", totalpage=" + totalpage + ", startpage="
				+ startpage + ", totalline=" + totalline + "]";
	}
	public int getTotalline() {
		return totalline;
	}
	public void setTotalline(int totalline) {
		this.totalline = totalline;
	}
	public int getCurpage() {
		return curpage;
	}
	public void setCurpage(int curpage) {
		this.curpage = curpage;
	}
	public int getPerpage() {
		return perpage;
	}
	public void setPerpage(int perpage) {
		this.perpage = perpage;
	}
	public int getTotalpage() {
		this.totalpage=(int)(Math.ceil(1.0*this.totalline/this.perpage));
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getStartpage() {
		startpage=(this.curpage-1)*perpage;
		return startpage;
	}
	public void setStartpage(int startpage) {
		this.startpage = startpage;
	}
}
