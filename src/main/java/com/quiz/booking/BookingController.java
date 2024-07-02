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
	
	// AJAX 요청 - id로 예약 삭제
	@ResponseBody
	@DeleteMapping("/delete-booking")
	public Map<String, Object> deleteBooking(
			@RequestParam("id") int id) {
		// delete DB
		int rowCount = bookingBO.deleteBookingById(id);
		
		// return AJAX
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("error_message", "삭제할 데이터가 없습니다.");
		}
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
		int rowCount = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		// return AJAX
		Map<String, Object> result = new HashMap<>();
		if (rowCount > 0) {
			result.put("code", 200);
			result.put("result", "성공");	
		} else {
			result.put("code", 500);
			result.put("error_message", "예약 실패");
		}
		
		return result;
	}
	
	// 조회하기 페이지
	@GetMapping("/check-booking-view")
	public String checkBookingView() {
		return "booking/checkBooking";
	}
	
	// Ajax 요청 - DB에서 조회하기 by 이름, 전화번호
	@ResponseBody
	@PostMapping("/check-booking")
	public Map<String, Object> checkBooking(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber) {
		// db에 조회하기
		Booking booking = bookingBO.getLatestBookingByNameAndPhoneNumber(name, phoneNumber) ;
		
		// ajax 리턴
		Map<String, Object> result = new HashMap<>();
		if (booking != null) {
			// {"code":200, "result":booking 객체}
			// {"code":200, "result":{"id":3, "name":"신보람" ...}}
			result.put("code", 200);
			result.put("result", booking);
		} else {
			// {"code":500, "error_message":"예약 내역이 없습니다."}
			result.put("code", 500);
			result.put("error_message", "해당하는 예약정보가 없습니다.");
		}
		return result;
	}
	
}
