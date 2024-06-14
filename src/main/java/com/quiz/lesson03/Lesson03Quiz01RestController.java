package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RequestMapping("/lesson03/quiz01")
@RestController // Spring bean
public class Lesson03Quiz01RestController {

	// DI
	private final RealEstateBO realEstateBO;
	
	@Autowired
	public Lesson03Quiz01RestController(RealEstateBO realEstateBO) {
		this.realEstateBO = realEstateBO;
	}
	
	// http://localhost:8080/lesson03/quiz01/1?id=20
	// input: id(필수), output: RealEstate
	@RequestMapping("/1")
	public RealEstate quiz01_1(
			@RequestParam("id") int id) {
		return realEstateBO.getRealEstateById(id);
	}
	
	// http://localhost:8080/lesson03/quiz01/2?rent_price=90
	// input: rent_price(필수), output: List<RealEstate>
	@RequestMapping("/2")
	public List<RealEstate> quiz01_2(
			@RequestParam("rent_price") int rentPrice) {
		return realEstateBO.getRealEstateListByRentPrice(rentPrice);
	}
	
	// http://localhost:8080/lesson03/quiz01/3?area=90&price=130000
//	@RequestMapping("/3")
//	public List<RealEstate> quiz01_3(
//			@RequestParam("area") int area
//			, @RequestParam("price") int price) {
//		
//	}
	
}
