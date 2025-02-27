package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;

@RestController // Spring bean
public class Lesson03Quiz03RestController {

	// Spring bean
	private final RealEstateBO realEstateBO;

	@Autowired
	public Lesson03Quiz03RestController(RealEstateBO realEstateBO) {
		this.realEstateBO = realEstateBO;
	}

	// http://localhost:8080/lesson03/quiz03/1?id=8&type=전세&price=70000
	@RequestMapping("/lesson03/quiz03/1")
	public String quiz03_1(
			@RequestParam("id") int id,
			@RequestParam("type") String type,
			@RequestParam("price") int price) {
		int rowCount = realEstateBO.updateRealEstateById(id, type, price);
		return "수정 성공 : " + rowCount; // HTML
	}
}
