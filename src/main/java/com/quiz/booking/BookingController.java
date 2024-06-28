package com.quiz.booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Map<String, Object> deleteBooking(int id) {
		
	}
	
}
