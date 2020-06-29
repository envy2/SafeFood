package com.ssafy.edu.vue.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.edu.vue.dto.CaloryDto;
import com.ssafy.edu.vue.dto.IngestionDto;
import com.ssafy.edu.vue.dto.FoodDto;
import com.ssafy.edu.vue.dto.FoodPageDTO;
import com.ssafy.edu.vue.dto.EatDto;
import com.ssafy.edu.vue.help.NumberResult;
import com.ssafy.edu.vue.service.IEatService;
import com.ssafy.edu.vue.service.IFoodService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value="SSAFY", description="SSAFY Resouces Management 2019")
public class FoodController {
	private static final Logger logger = LoggerFactory.getLogger(FoodController.class);
	
	@Autowired
	private IFoodService iFoodService;
	
	@ApiOperation(value = "모든 음식의 정보를 반환한다.", response = List.class)
	@RequestMapping(value = "/findAllFoods", method = RequestMethod.GET)
	public ResponseEntity<List<FoodDto>> findAllFoods() throws Exception {
		logger.info("1-------------findAllFoods-----------------------------"+new Date());
		List<FoodDto> foods = iFoodService.findAllFoods();
		if (foods.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FoodDto>>(foods, HttpStatus.OK);
	}
	
	@ApiOperation(value = "코드로 상품을 검색한다.", response = FoodDto.class)
	@RequestMapping(value = "/findFoodCode/{code}", method = RequestMethod.GET)
	public ResponseEntity<FoodDto> findFoodCode(@PathVariable int code) throws Exception {
		logger.info("1-------------findFoodCode-----------------------------"+new Date());
		logger.info("1-------------findFoodCode-----------------------------"+code);
		FoodDto food = iFoodService.findFoodCode(code);
		return new ResponseEntity<FoodDto>(food, HttpStatus.OK);
	}
	
	@ApiOperation(value = "6개의 음식을 반환한다.", response = List.class)
   	@RequestMapping(value = "/findPageFoods", method = RequestMethod.GET)
   	public ResponseEntity<List<FoodDto>> findPageFoods(@PathVariable int page) throws Exception {
   		logger.info("1-------------findPageFoods-----------------------------"+new Date());
   		List<FoodDto> foods = iFoodService.findPageFoods(page);
   		if (foods.isEmpty()) {
   			return new ResponseEntity(HttpStatus.NO_CONTENT);
   		}
   		return new ResponseEntity<List<FoodDto>>(foods, HttpStatus.OK);
   	}
	
	@ApiOperation(value = "이름의 일부분에 해당하는 음식의 정보를 반환한다.", response = List.class)
	@RequestMapping(value = "/searchFoods/{s_category}/{s_keyword}", method = RequestMethod.GET)
	public ResponseEntity<List<FoodDto>> searchFoods(@PathVariable String s_category,@PathVariable String s_keyword) throws Exception {
		logger.info("3-------------searchFoods-----------------------------"+new Date());
		logger.info("3-------------searchFoods-----------------------------"+s_category + ", "+s_keyword);
		HashMap<String, String> foodMap=new HashMap<>();
		foodMap.put("s_category", s_category);
		foodMap.put("s_keyword", s_keyword);
		List<FoodDto> foods = iFoodService.searchFoods(foodMap);
		logger.info("3-------------searchFoods-----------------------------"+foods.size());
		return new ResponseEntity<List<FoodDto>>(foods, HttpStatus.OK);
	}
	
	@ApiOperation(value = "새로운 음식을 등록한다.", response = NumberResult.class)
   	@RequestMapping(value = "/addFood", method = RequestMethod.POST)
   	public void addFood(@RequestBody FoodDto food) throws Exception {
   		logger.info("5-------------addFood-----------------------------"+new Date());
   		logger.info("5-------------addFood-----------------------------"+food);
   		iFoodService.addFood(food);
   	}
		

	@ApiOperation(value = "많이 먹은 식품 3개를 반환한다.", response = List.class)
	@RequestMapping(value = "/Eat_a_Lot/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<FoodDto>> Eat_a_Lot(@PathVariable String id) throws Exception {
		logger.info("1-------------Eat_a_Lot-----------------------------"+new Date());
		List<FoodDto> foods = iFoodService.Eat_a_Lot(id);
		
		return new ResponseEntity<List<FoodDto>>(foods, HttpStatus.OK);
	}
	
	
/*-----------------------------------------PAGING---------------------------------------------------------------*/	
	
	@ApiOperation(value = "페이지에 해당하는 식품 정보를 반환한다.", response = FoodPageDTO.class)
	@RequestMapping(value = "/findAllFoodByPage/{curpage}/{perpage}", method = RequestMethod.GET)
	public ResponseEntity<FoodPageDTO> findAllFoodByPage(
			@PathVariable int curpage,	
			@PathVariable int perpage ) throws Exception {
		logger.info("3-------------findAllFoodByPage-----------------------------"+new Date());
		
		FoodPageDTO pbean=new FoodPageDTO();
		pbean.setCurpage(curpage);
		pbean.setPerpage(perpage);
		int totalline=iFoodService.getFoodsTotal();
		pbean.setTotalline(totalline);
		int startpage=pbean.getStartpage();
		
		logger.info("3-------------findLikeEmployees-----------------------------"+startpage);
		List<FoodDto> foods = iFoodService.findAllFoodByPage(pbean);
		pbean.setEmps(foods);
		
		if (foods.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<FoodPageDTO>(pbean, HttpStatus.OK);

	}
}
