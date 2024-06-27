package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;
	
	// 즐겨찾기 추가하기 페이지 : http://localhost:8080/lesson06/add-bookmark-view
	@GetMapping("/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	// 즐겨찾기 추가하기 : Ajax -> ResponseBody로 return 해야함!!
	@ResponseBody
	@PostMapping("/add-bookmark")
	public String addBookmark(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		// insert db
		int rowCount = bookmarkBO.addBookmark(name, url);
		
		// return to AJAX
		return "success";
	}
	
	// 즐겨찾기 목록 페이지
	@GetMapping("/bookmark-list-view")
	public String bookmarkListView(Model model) {
		// select로 bookmark 튜플들 가져오기
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		model.addAttribute("bookmarkList", bookmarkList);
		
		return "lesson06/bookmarkList";
	}
}
