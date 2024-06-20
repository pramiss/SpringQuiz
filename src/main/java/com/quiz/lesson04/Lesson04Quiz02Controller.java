package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {

	private final RealtorBO realtorBO;
	
	@Autowired
	public Lesson04Quiz02Controller(RealtorBO realtorBO) {
		this.realtorBO = realtorBO;
	}
	
	// http://localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	 
	// addRealtor.html에서 접속(form)
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor,
			Model model) {
		// 1. DB insert - realtor를 넣고, id를 다시 저장
		realtorBO.addRealtor(realtor);

		// 2. DB select - 위에서 가져온 id로.
		Realtor latestRealtor = realtorBO.getRealtorById(realtor.getId());

		// 3. Model - 가져온 Realtor 데이터 담기
		model.addAttribute("realtor", latestRealtor);
		
		// 4. HTML 이동 - 결과화면 출력
		return "lesson04/afterAddRealtor";
	}
}
