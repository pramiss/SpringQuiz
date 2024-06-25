package com.quiz.weather_history.bo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.domain.WeatherHistory;
import com.quiz.weather_history.mapper.WeatherHistoryMapper;

@Service
public class WeatherHistoryBO {
	
	@Autowired
	private WeatherHistoryMapper weatherHistoryMapper;
	
	// SELECT, input: X, output: List<WeatherHistory>
	public List<WeatherHistory> getWeatherHistoryList() {
		return weatherHistoryMapper.selectWeatherHistoryList();
	}
	
	// INSERT, input: fields, output: X
	public void addWeatherHistory(LocalDate date, String weather, double temperatures,
			double precipitation, String microDust, double windSpeed) {
		weatherHistoryMapper.insertWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);;
	}
	
}
