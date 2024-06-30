package com.quiz.booking.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.booking.domain.Booking;

@Mapper
public interface BookingMapper {
	
	// SELECT, input: x, output: List<Booking>
	public List<Booking> selecttBookingList();
	
	// DELETE, input: id, output: int
	public int deleteBookingById(int id);
	
	// INSERT, input: params, output: int
	public int insertBooking(
			@Param("name") String name,
			@Param("date") LocalDate date,
			@Param("day") int day,
			@Param("headcount") int headcount,
			@Param("phoneNumber") String phoneNumber);
}
