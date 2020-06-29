package com.ssafy.edu.vue.dao;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.edu.vue.dto.BoardDto;
import com.ssafy.edu.vue.dto.CaloryDto;
import com.ssafy.edu.vue.dto.IngestionDto;
import com.ssafy.edu.vue.dto.PageBoardDto;
import com.ssafy.edu.vue.dto.FoodDto;
import com.ssafy.edu.vue.dto.FoodPageDTO;
import com.ssafy.edu.vue.dto.EatDto;
import com.ssafy.edu.vue.dto.UserDto;


@Mapper
public interface HrmMapper {
	
	public void addFood(FoodDto food) throws Exception;
	public FoodDto findFoodCode(int code) throws Exception;
	public List<FoodDto> findPageFoods(int num) throws Exception;
	public List<FoodDto> findAllFoods() throws Exception;
	public List<FoodDto> searchFoods(HashMap<String, String> foodMap) throws Exception;
	public List<FoodDto> Eat_a_Lot(String id) throws Exception;
	
	
	public void insertUser(UserDto user) throws Exception;
	public UserDto login(UserDto user) throws Exception;
	public void updateUser(UserDto user) throws Exception;
	public void deleteUser(String id) throws Exception;
	public UserDto findPassword(UserDto user) throws Exception;
	public UserDto findId(UserDto user) throws Exception;
	public UserDto findName(UserDto user) throws Exception;
	
	
	public void addBoard(BoardDto board) throws Exception;
	public List<BoardDto> boardAllLists() throws Exception;
	public void deleteBoard(int no) throws Exception;
	public void updateBoard(BoardDto board) throws Exception;
	public BoardDto findBoardByNo(int no) throws Exception;
	public void updateReadCount(int no) throws Exception;
	
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
	
	public List<BoardDto> findAllBoardByPage(PageBoardDto pbean) throws Exception;
	public List<FoodDto> findAllFoodByPage(FoodPageDTO pbean) throws Exception;
}
