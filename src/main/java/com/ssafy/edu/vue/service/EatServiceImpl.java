package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.edu.vue.dao.SSAFyDaoImpl;
import com.ssafy.edu.vue.dto.CaloryDto;
import com.ssafy.edu.vue.dto.IngestionDto;
import com.ssafy.edu.vue.dto.UserDto;
import com.ssafy.edu.vue.dto.EatDto;
import com.ssafy.edu.vue.dto.FoodDto;

@Service
public class EatServiceImpl implements IEatService {

	@Autowired
	private SSAFyDaoImpl eatdao;

	@Override
	public void basketFood(EatDto eat) throws Exception {
		eatdao.basketFood(eat);
	}

	@Override
	public int findSelectFoods(EatDto eat) throws Exception {
		return eatdao.findSelectFoods(eat);
	}

	@Override
	public List<EatDto> AllBasketList(String id) throws Exception {
		return eatdao.AllBasketList(id);
	}

	@Override
	public void ingestionFood(EatDto eat) throws Exception {
		eatdao.ingestionFood(eat);
	}

	@Override
	public void deleteBasket(EatDto eat) throws Exception {
		eatdao.deleteBasket(eat);
	}

	@Override
	public List<IngestionDto> AllIngestionList(IngestionDto eat) throws Exception {
		return eatdao.AllIngestionList(eat);
	}

	@Override
	public CaloryDto CaloryDay(IngestionDto eat) throws Exception {
		return eatdao.CaloryDay(eat);
	}

	@Override
	public CaloryDto CaloryDayPercent(IngestionDto eat) throws Exception {
		return eatdao.CaloryDayPercent(eat);
	}

	@Override
	public CaloryDto CaloryDays(IngestionDto eat) throws Exception {
		return eatdao.CaloryDays(eat);
	}

	@Override
	public CaloryDto CaloryDaysPercent(IngestionDto eat) throws Exception {
		return eatdao.CaloryDaysPercent(eat);
	}

	@Override
	public UserDto userAllergy(EatDto eat) throws Exception {
		return eatdao.userAllergy(eat);
	}

	@Override
	public FoodDto foodAllergy(EatDto eat) throws Exception {
		return eatdao.foodAllergy(eat);
	}
	



}
