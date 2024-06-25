package com.quiz.weather_history.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryMapper {
	
	// SELECT, input: X, output: List<weatherHistory>
	public List<WeatherHistory> selectWeatherHistoryList();
	
	// INSERT, input: fields, output: X
	public void insertWeatherHistory(
			@Param("date") LocalDate date,
			@Param("weather") String weather,
			@Param("temperatures") double temperatures,
			@Param("precipitation") double precipitation,
			@Param("microDust") String microDust,
			@Param("windSpeed") double windSpeed);
}
