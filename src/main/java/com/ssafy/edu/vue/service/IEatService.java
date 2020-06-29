package com.ssafy.edu.vue.service;

import java.util.List;

import com.ssafy.edu.vue.dto.CaloryDto;
import com.ssafy.edu.vue.dto.IngestionDto;
import com.ssafy.edu.vue.dto.UserDto;
import com.ssafy.edu.vue.dto.EatDto;
import com.ssafy.edu.vue.dto.FoodDto;

public interface IEatService {
	public void basketFood(EatDto eat) throws Exception;
	public int findSelectFoods(EatDto eat) throws Exception;
	public List<EatDto> AllBasketList(String id) throws Exception;
	public void ingestionFood(EatDto eat) throws Exception;
	public void deleteBasket(EatDto eat) throws Exception;
	public List<IngestionDto> AllIngestionList(IngestionDto eat) throws Exception;
	public CaloryDto CaloryDay(IngestionDto eat) throws Exception;
	public CaloryDto CaloryDayPercent(IngestionDto eat) throws Exception;
	public CaloryDto CaloryDays(IngestionDto eat) throws Exception;
	public CaloryDto CaloryDaysPercent(IngestionDto eat) throws Exception;
	public UserDto userAllergy(EatDto eat) throws Exception;
	public FoodDto foodAllergy(EatDto eat) throws Exception;
}
