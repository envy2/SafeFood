package com.ssafy.edu.vue.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.vue.dto.BoardDto;
import com.ssafy.edu.vue.dto.CaloryDto;
import com.ssafy.edu.vue.dto.IngestionDto;
import com.ssafy.edu.vue.dto.PageBoardDto;
import com.ssafy.edu.vue.dto.FoodDto;
import com.ssafy.edu.vue.dto.FoodPageDTO;
import com.ssafy.edu.vue.dto.EatDto;
import com.ssafy.edu.vue.dto.UserDto;

@Repository
public class SSAFyDaoImpl implements HrmMapper{
	
    private String ns="com.ssafy.edu.vue.dao.HrmMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void addFood(FoodDto food) throws Exception {
		sqlSession.insert(ns+"addFood", food);
	}
	@Override
	public FoodDto findFoodCode(int code) throws Exception {
		return sqlSession.selectOne(ns+"findFoodCode", code);
	}
	
	@Override
	public List<FoodDto> findPageFoods(int num) throws Exception {
		return sqlSession.selectList(ns+"findPageFoods", num);
	}
	
	@Override
	public List<FoodDto> findAllFoods() throws Exception {
		return sqlSession.selectList(ns+"findAllFoods");
	}
	
	@Override
	public List<FoodDto> searchFoods(HashMap<String, String> foodMap) throws Exception {
		return sqlSession.selectList(ns+"searchFoods", foodMap);
	}
	
	@Override
	public void insertUser(UserDto user) throws Exception {
		sqlSession.insert(ns+"insertUser", user);
	}
	
	@Override
	public UserDto login(UserDto user) throws Exception {
		return sqlSession.selectOne(ns+"login", user);
	}

	@Override
	public void addBoard(BoardDto board) throws Exception {
		sqlSession.insert(ns+"addBoard",board);
	}

	@Override
	public List<BoardDto> boardAllLists() throws Exception {
		return sqlSession.selectList(ns+"boardAllLists");
	}
	@Override
	public void deleteBoard(int no) throws Exception {
		sqlSession.delete(ns+"deleteBoard",no);
	}
	@Override
	public void updateBoard(BoardDto board) throws Exception {
		sqlSession.update(ns+"updateBoard",board);
	}
	@Override
	public BoardDto findBoardByNo(int no) throws Exception {
		return sqlSession.selectOne(ns+"findBoardByNo",no);
	}
	@Override
	public void updateUser(UserDto user) throws Exception {
		sqlSession.update(ns+"updateUser",user);
	}
	@Override
	public void deleteUser(String id) throws Exception {
		sqlSession.delete(ns+"deleteUser",id);
	}
	@Override
	public void updateReadCount(int no) throws Exception {
		sqlSession.update(ns+"updateReadCount",no);
	}
	@Override
	public List<FoodDto> Eat_a_Lot(String id) throws Exception {
		return sqlSession.selectList(ns+"Eat_a_Lot",id);
	}
	@Override
	public void basketFood(EatDto eat) throws Exception {
		sqlSession.update(ns+"basketFood",eat);
	}
	@Override
	public int findSelectFoods(EatDto eat) throws Exception {
		return sqlSession.selectOne(ns+"findSelectFoods",eat);
	}
	@Override
	public List<EatDto> AllBasketList(String id) throws Exception {
		return sqlSession.selectList(ns+"AllBasketList",id);
	}
	@Override
	public void ingestionFood(EatDto eat) throws Exception {
		sqlSession.insert(ns+"ingestionFood",eat);
	}
	@Override
	public void deleteBasket(EatDto eat) throws Exception {
		sqlSession.delete(ns+"deleteBasket",eat);
	}
	@Override
	public List<IngestionDto> AllIngestionList(IngestionDto eat) throws Exception {
		return sqlSession.selectList(ns+"AllIngestionList",eat);
	}
	@Override
	public CaloryDto CaloryDay(IngestionDto eat) throws Exception {
		return sqlSession.selectOne(ns+"CaloryDay",eat);
	}
	@Override
	public CaloryDto CaloryDayPercent(IngestionDto eat) throws Exception {
		return sqlSession.selectOne(ns+"CaloryDayPercent",eat);
	}
	@Override
	public CaloryDto CaloryDays(IngestionDto eat) throws Exception {
		return sqlSession.selectOne(ns+"CaloryDays",eat);
	}
	@Override
	public CaloryDto CaloryDaysPercent(IngestionDto eat) throws Exception {
		return sqlSession.selectOne(ns+"CaloryDaysPercent",eat);
	}
	
	@Override
	public UserDto userAllergy(EatDto eat) throws Exception {
		return sqlSession.selectOne(ns+"userAllergy",eat);
	}
	
	@Override
	public FoodDto foodAllergy(EatDto eat) throws Exception {
		return sqlSession.selectOne(ns+"foodAllergy",eat);
	}
	@Override
	public UserDto findPassword(UserDto user) throws Exception {
		return sqlSession.selectOne(ns + "findPassword", user);
	}
	@Override
	public UserDto findId(UserDto user) throws Exception {
		return sqlSession.selectOne(ns+"findId",user);
	}
	@Override
	public UserDto findName(UserDto user) throws Exception {
		return sqlSession.selectOne(ns+"findName",user);
	}
//	---------------------------------PAGING------------------------------------
	
	public List<BoardDto> findAllBoardByPage(PageBoardDto pbean) throws Exception{
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns + "findAllBoardByPage", pbean);
	}
	public List<FoodDto> findAllFoodByPage(FoodPageDTO pbean) throws Exception{
		// TODO Auto-generated method stub
		return sqlSession.selectList(ns + "findAllFoodByPage", pbean);
	}
	
	
	
	
	
}
