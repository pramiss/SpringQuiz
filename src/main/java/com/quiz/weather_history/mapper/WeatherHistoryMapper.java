package com.quiz.weather_history.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.weather_history.domain.WeatherHistory;

@Mapper
public interface WeatherHistoryMapper {
	
	// SELECT, input: X, output: List<weatherHistory>
	public List<WeatherHistory> selectWeatherHistoryList();
	
	// INSERT, input: WeatherHistory, output: X
	public void insertWeatherHistory(WeatherHistory weatherHistory);
}
