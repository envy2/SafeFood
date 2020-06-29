package com.ssafy.edu.vue.controller;

import java.util.Date;
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
import com.ssafy.edu.vue.dto.UserDto;
import com.ssafy.edu.vue.dto.EatDto;
import com.ssafy.edu.vue.dto.FoodDto;
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
public class EatController {
	private static final Logger logger = LoggerFactory.getLogger(FoodController.class);
	
	@Autowired
	private IEatService iEatService;
	
	@ApiOperation(value = "음식을 찜한다.", response = NumberResult.class)
	@RequestMapping(value = "/basketFood", method = RequestMethod.POST)
	public ResponseEntity<NumberResult> basketFood(@RequestBody EatDto eat) throws Exception {
		logger.info("5-------------basketFood-----------------------------"+new Date());
		logger.info("5-------------basketFood-----------------------------"+eat);
		NumberResult nr=new NumberResult();
		
		if(iEatService.findSelectFoods(eat) == 0) {
			iEatService.basketFood(eat);
			nr.setState("succ");
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}
	
	@ApiOperation(value = "찜한 상품의 리스트를 반환한다.", response = List.class)
	@RequestMapping(value = "/AllBasketList/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<EatDto>> AllBasketList(@PathVariable String id) throws Exception {
		logger.info("1-------------AllBasketList-----------------------------"+new Date());
		List<EatDto> foods = iEatService.AllBasketList(id);
		
		return new ResponseEntity<List<EatDto>>(foods, HttpStatus.OK);
	}
	
	@ApiOperation(value = "음식을 먹는다.", response = NumberResult.class)
	@RequestMapping(value = "/ingestionFood", method = RequestMethod.POST)
	public ResponseEntity<NumberResult> ingestionFood(@RequestBody EatDto eat) throws Exception {
		logger.info("5-------------ingestionFood-----------------------------"+new Date());
		logger.info("5-------------ingestionFood-----------------------------"+eat);
		UserDto user = iEatService.userAllergy(eat);
		FoodDto food = iEatService.foodAllergy(eat);
		
		NumberResult nr=new NumberResult();
		boolean check = true;
		if(user != null) {
			String[] allregy = user.getAlr().split(",");
			for (int i = 0; i < allregy.length; i++) {
				if(food.getMaterial().contains(allregy[i])) {
					check = false;
				}
			}
		}
		if(check) {
			if(eat.getNumber() > 0) {
				iEatService.ingestionFood(eat);
				nr.setState("섭취하였습니다.");
			}
			else {
				nr.setState("삭제하였습니다.");
			}
		}
		else {
			if(eat.getNumber() > 0) {
				nr.setState("경고! 알러지가 포함되어있어 섭취 할 수 없습니다.");
			}
			else {
				nr.setState("삭제하였습니다.");
			}
		}
		
		iEatService.deleteBasket(eat);
		logger.info("5-------------deleteBasket-----------------------------"+eat);
		
		return new ResponseEntity<NumberResult>(nr, HttpStatus.OK);
	}
	
	@ApiOperation(value = "섭취 상품의 리스트를 반환한다.", response = List.class)
	@RequestMapping(value = "/AllIngestionList", method = RequestMethod.POST)
	public ResponseEntity<List<IngestionDto>> AllIngestionList(@RequestBody IngestionDto eat) throws Exception {
		logger.info("1-------------AllIngestionList-----------------------------"+eat);
		List<IngestionDto> foods = iEatService.AllIngestionList(eat);
		
		logger.info("1-------------AllIngestionList-----------------------------"+foods);
		return new ResponseEntity<List<IngestionDto>>(foods, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "섭취 상품의 영양성분 리스트를 반환한다.", response = List.class)
	@RequestMapping(value = "/CaloryDay", method = RequestMethod.POST)
	public ResponseEntity<CaloryDto> CaloryDay(@RequestBody IngestionDto eat) throws Exception {
		logger.info("1-------------CaloryDay-----------------------------"+eat);
		CaloryDto foods = iEatService.CaloryDay(eat);
		
		logger.info("1-------------CaloryDto-----------------------------"+foods);
		return new ResponseEntity<CaloryDto>(foods, HttpStatus.OK);
	}
	
	@ApiOperation(value = "섭취 상품의 영양성분 % 리스트를 반환한다.", response = List.class)
	@RequestMapping(value = "/CaloryDayPercent", method = RequestMethod.POST)
	public ResponseEntity<CaloryDto> CaloryDayPercent(@RequestBody IngestionDto eat) throws Exception {
		logger.info("1-------------CaloryDayPercent-----------------------------"+eat);
		CaloryDto food = iEatService.CaloryDay(eat);
		
		CaloryDto foods = new CaloryDto(
				(int)(food.getCalory()/2600*100),
				(int)(food.getCarbo()/330*100),
				(int)(food.getProtein()/60*100),
				(int)(food.getFat()/90*100),
				(int)(food.getSugar()/25*100),
				(int)(food.getNatrium()/2000*100),
				(int)(food.getChole()/15*100),
				(int)(food.getFatty_acid()/15*100),
				(int)(food.getTrans_fat()/2*100));
		
		logger.info("1-------------CaloryDto-----------------------------"+foods);
		return new ResponseEntity<CaloryDto>(foods, HttpStatus.OK);
	}
	

	@ApiOperation(value = "기간별 섭취 상품의 영양성분 리스트를 반환한다.", response = List.class)
	@RequestMapping(value = "/CaloryDays", method = RequestMethod.POST)
	public ResponseEntity<CaloryDto> CaloryDays(@RequestBody IngestionDto eat) throws Exception {
		logger.info("1-------------CaloryDays-----------------------------"+eat);
		CaloryDto foods = iEatService.CaloryDays(eat);
		
		logger.info("1-------------CaloryDto-----------------------------"+foods);
		return new ResponseEntity<CaloryDto>(foods, HttpStatus.OK);
	}
	
	@ApiOperation(value = "기간 별 섭취 상품의 영양성분 % 리스트를 반환한다.", response = List.class)
	@RequestMapping(value = "/CaloryDaysPercent", method = RequestMethod.POST)
	public ResponseEntity<CaloryDto> CaloryDaysPercent(@RequestBody IngestionDto eat) throws Exception {
		logger.info("1-------------CaloryDaysPercent-----------------------------"+eat);
		CaloryDto food = iEatService.CaloryDays(eat);
		
		String[] start = eat.getStartday().split("-");
		String[] end = eat.getEndday().split("-");
		int day = ( Integer.parseInt(end[0]) - Integer.parseInt(start[0]) ) * 365;
		day += ( Integer.parseInt(end[1]) - Integer.parseInt(start[1]) ) * 30;
		day +=  Integer.parseInt(end[2]) - Integer.parseInt(start[2]) + 1;
		
		CaloryDto foods = new CaloryDto(
				(int)(food.getCalory()/2600*100/day),
				(int)(food.getCarbo()/330*100/day),
				(int)(food.getProtein()/60*100/day),
				(int)(food.getFat()/90*100/day),
				(int)(food.getSugar()/25*100/day),
				(int)(food.getNatrium()/2000*100/day),
				(int)(food.getChole()/15*100/day),
				(int)(food.getFatty_acid()/15*100/day),
				(int)(food.getTrans_fat()/2*100/day));
		
		
		logger.info("1-------------CaloryDto-----------------------------"+foods);
		return new ResponseEntity<CaloryDto>(foods, HttpStatus.OK);
	}
	
	@ApiOperation(value = "일일 권장량의 기준을 반환한다.", response = List.class)
	@RequestMapping(value = "/StandardDay", method = RequestMethod.POST)
	public ResponseEntity<CaloryDto> StandardDay(@RequestBody IngestionDto eat) throws Exception {
		logger.info("1-------------StandardDay-----------------------------"+eat);
		CaloryDto foods = new CaloryDto(2600, 330, 60, 90, 25, 2000, 15, 15, 2);
		
		logger.info("1-------------CaloryDto-----------------------------"+foods);
		return new ResponseEntity<CaloryDto>(foods, HttpStatus.OK);
	}
	
	@ApiOperation(value = "기간별 권장량의 기준을 반환한다.", response = List.class)
	@RequestMapping(value = "/StandardDays", method = RequestMethod.POST)
	public ResponseEntity<CaloryDto> StandardDays(@RequestBody IngestionDto eat) throws Exception {
		logger.info("1-------------StandardDays-----------------------------"+eat);
		String[] start = eat.getStartday().split("-");
		String[] end = eat.getEndday().split("-");
		int day = ( Integer.parseInt(end[0]) - Integer.parseInt(start[0]) ) * 365;
		day += ( Integer.parseInt(end[1]) - Integer.parseInt(start[1]) ) * 30;
		day +=  Integer.parseInt(end[2]) - Integer.parseInt(start[2]) + 1;
		CaloryDto foods = new CaloryDto(2600* day, 330* day, 60* day, 90* day, 25* day, 2000* day, 15* day, 15* day, 2* day);
		
		logger.info("1-------------CaloryDto-----------------------------"+foods);
		return new ResponseEntity<CaloryDto>(foods, HttpStatus.OK);
	}
}
