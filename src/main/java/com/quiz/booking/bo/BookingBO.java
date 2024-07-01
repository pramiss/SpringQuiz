package com.quiz.booking.bo;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.booking.domain.Booking;
import com.quiz.booking.mapper.BookingMapper;

@Service
public class BookingBO {
	
	private final BookingMapper bookingMapper;
	
	@Autowired
	public BookingBO(BookingMapper bookingMapper) {
		this.bookingMapper = bookingMapper;
	}
	
	// SELECT, input: x, output: List<Booking>
	public List<Booking> getBookingList() {
		return bookingMapper.selecttBookingList();
	}

	// DELETE, input: id, output: rowCount
	public int deleteBookingById(int id) {
		return bookingMapper.deleteBookingById(id);
	}
	
	// INSERT, input: params, output: rowCount
	public int addBooking(String name, LocalDate date, int day, int headcount, String phoneNumber) {
		return bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	};
	
	// SELECT, input: name, phoneNumber, output: Booking
	public Booking getBookingByNameAndPhoneNumber(String name, String phoneNumber) {
		return bookingMapper.selectBookingByNameAndPhoneNumber(name, phoneNumber);
	};
}
