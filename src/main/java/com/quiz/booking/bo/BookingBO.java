package com.quiz.booking.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
