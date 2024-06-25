package com.quiz.delivery;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/delivery")
@Controller
public class DeliveryController {

	@GetMapping("/store-list-view")
	public String storeListView(Model model) {
		// 1. select로 store리스트 가져오기
		
		return "delivery/storeList";
	}
}
