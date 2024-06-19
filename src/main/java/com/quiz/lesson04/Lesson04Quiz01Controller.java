package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller // Spring bean
public class Lesson04Quiz01Controller {

	private final SellerBO sellerBO;
	
	@Autowired
	public Lesson04Quiz01Controller(SellerBO sellerBO) {
		this.sellerBO = sellerBO;
	}
	
	// http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// seller DB에 데이터 추가 -> 결과화면(HTML)
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "temperature", defaultValue = "36.5") double temperature,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl) {
		
		// DB에 데이터 추가
		sellerBO.addSeller(nickname, temperature, profileImageUrl);
		
		// 성공화면으로 이동
		return "lesson04/afterAddSeller";
	}
	
	// 방금 가입한 판매자 1명 화면
	// http://localhost:8080/lesson04/quiz01/seller-info-view
	// http://localhost:8080/lesson04/quiz01/seller-info-view?id=3
	@GetMapping("/seller-info-view")
	public String sellerInfoView(
			@RequestParam(value = "id", required = false) Integer id,
			Model model) {
		
		// DB에서 판매자 데이터 가져오기
		Seller seller = null;
		
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		
		if (seller == null) {
			seller = sellerBO.getLatestSeller();
		}

		// Model에 데이터 넣기
		model.addAttribute("seller", seller);
		model.addAttribute("title", "판매자 정보");

		// HTML 주소 리턴
		return "lesson04/sellerInfo";
	}
}
