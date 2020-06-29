package com.ssafy.edu.vue.service;

import java.util.HashMap;
import java.util.List;

import com.ssafy.edu.vue.dto.FoodDto;
import com.ssafy.edu.vue.dto.FoodPageDTO;


public interface IFoodService {
	public void addFood(FoodDto food) throws Exception;
	public FoodDto findFoodCode(int code) throws Exception;
	public List<FoodDto> findPageFoods(int num) throws Exception;
	public List<FoodDto> findAllFoods() throws Exception;
	public List<FoodDto> searchFoods(HashMap<String, String> foodMap) throws Exception;
	public List<FoodDto> Eat_a_Lot(String id) throws Exception;
	
	public int getFoodsTotal() throws Exception;
	public List<FoodDto> findAllFoodByPage(FoodPageDTO pbean) throws Exception;
}
