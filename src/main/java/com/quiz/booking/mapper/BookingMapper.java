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
	
	// DELETE, input: id, output: rowCount
	public int deleteBookingById(int id);
	
	// INSERT, input: params, output: rowCount
	public int insertBooking(
			@Param("name") String name,
			@Param("date") LocalDate date,
			@Param("day") int day,
			@Param("headcount") int headcount,
			@Param("phoneNumber") String phoneNumber);
	
	// SELECT, input: name, phoneNumber, output: Booking
	public Booking getBookingByNameAndPhoneNumber(
			@Param("name") String name,
			@Param("phoneNumber") String phoneNumber);
}
