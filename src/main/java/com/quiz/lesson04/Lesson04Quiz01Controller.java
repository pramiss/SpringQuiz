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
			@RequestParam(value = "temperature", required = false) Double temperature,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl) {
		
		// DB에 데이터 추가
		sellerBO.addSeller(nickname, temperature, profileImageUrl);
		
		return "lesson04/afterAddSeller";
	}
	
	// http://localhost:8080/lesson04/quiz01/seller-info-view
	@GetMapping("/seller-info-view")
	public String sellerInfoView(Model model) {
		// DB에서 판매자 데이터 가져오기
		Seller seller = sellerBO.getSeller();
		
		// 데이터 Model에 넣기
		model.addAttribute("result", seller);
		model.addAttribute("title", "판매자 정보");
		
		return "lesson04/sellerInfo";
	}
}
