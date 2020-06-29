package com.ssafy.edu.vue.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.SSAFyDaoImpl;
import com.ssafy.edu.vue.dto.FoodDto;
import com.ssafy.edu.vue.dto.FoodPageDTO;


@Service
public class FoodServiceImpl implements IFoodService {

	@Autowired
	private SSAFyDaoImpl fooddao;
	
	@Override
	@Transactional
	public void addFood(FoodDto food) throws Exception {
		fooddao.addFood(food);
	}

	@Override
	@Transactional(readOnly=true)
	public FoodDto findFoodCode(int code) throws Exception {
		return fooddao.findFoodCode(code);
	}

	@Override
	@Transactional(readOnly=true)
	public List<FoodDto> findPageFoods(int num) throws Exception {
		return fooddao.findPageFoods(num);
	}

	@Override
	@Transactional(readOnly=true)
	public List<FoodDto> findAllFoods() throws Exception {
		return fooddao.findAllFoods();
	}

	@Override
	@Transactional(readOnly=true)
	public List<FoodDto> searchFoods(HashMap<String, String> foodMap) throws Exception {
		return fooddao.searchFoods(foodMap);
	}

	@Override
	public List<FoodDto> Eat_a_Lot(String id) throws Exception {
		return fooddao.Eat_a_Lot(id);
	}

//	------------------------------PAGING-----------------------------------
	@Override
	@Transactional(readOnly=true)
	public int getFoodsTotal() throws Exception {
		// TODO Auto-generated method stub
		int total = fooddao.findAllFoods().size();
		return total;
	}

	@Override
	@Transactional(readOnly=true)
	public List<FoodDto> findAllFoodByPage(FoodPageDTO pbean) throws Exception {
		// TODO Auto-generated method stub
		return fooddao.findAllFoodByPage(pbean);
	}
}
