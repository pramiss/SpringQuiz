package com.quiz.booking;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.booking.bo.BookingBO;
import com.quiz.booking.domain.Booking;


@RequestMapping("/booking")
@Controller
public class BookingController {

	private final BookingBO bookingBO;
	
	@Autowired
	public BookingController(BookingBO bookingBO) {
		this.bookingBO = bookingBO;
	}
	
	// http://localhost:8080/booking/booking-list-view
	// 예약 목록 페이지
	@GetMapping("/booking-list-view")
	public String bookingListView(Model model) {
		// SELECT 예약목록 - booking 테이블
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		
		return "booking/bookingList";
	}
	
	// AJAX 요청 - 예약 삭제
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		// delete DB
		boolean isDelete = bookingBO.deleteBookingById(id);
		
		// return AJAX
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_delete", isDelete);
		return result;
	}
	
	// 예약하기 페이지
	@GetMapping("/make-booking-view")
	public String makeBookingView() {
		return "booking/makeBooking";
	}
	
	// AJAX 요청 - 예약 추가
	@ResponseBody
	@PostMapping("/make-booking")
	public Map<String, Object> makeBooking(
			@RequestParam("name") String name
			, @RequestParam("date") LocalDate date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		// DB insert
		boolean isInsert = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		// return AJAX
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("isInsert", isInsert);
		return result;
	}
	
}
