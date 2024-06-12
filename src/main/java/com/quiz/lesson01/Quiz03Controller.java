package com.quiz.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // View와 연결할 것
public class Quiz03Controller {
		
	@RequestMapping("/lesson01/quiz03")
	public String quiz03() {
		return "lesson01/quiz03";
	}
}
