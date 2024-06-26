package com.quiz.weather_history;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.weather_history.bo.WeatherHistoryBO;
import com.quiz.weather_history.domain.WeatherHistory;

@RequestMapping("/weather-history")
@Controller
public class WeatherHistoryController {

	@Autowired
	private WeatherHistoryBO weatherHistoryBO;
	
	// 날씨 목록 화면 /weather-history/weather-list-view
	@GetMapping("/weather-list-view")
	public String weatherListView(Model model) {
		// weather_history 테이블에서 전부 select 해오기
		List<WeatherHistory> weatherHistoryArray = weatherHistoryBO.getWeatherHistoryList();
		model.addAttribute("weatherHistoryArray", weatherHistoryArray);
		
		return "weather_history/weatherList";
	}
	
	// 날씨 추가 화면 /weather-history/add-weather-view
	@GetMapping("/add-weather-view")
	public String addWeatherView() {
		return "weather_history/addWeather";
	}
	
	// 날씨 추가 후 리다이렉트, /weather-history/add-weather
	@PostMapping("/add-weather")
	public String addWeather(
			@RequestParam("date") /* DateTimeFormat(pattern = "yyyy-MM-dd") */ LocalDate date, // LocalDate는 자동변환되므로 어노테이션이 필요없다.
			@RequestParam("weather") String weather,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed) {
		// 1. DB에 받은 데이터 추가
		weatherHistoryBO.addWeatherHistory(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		// 2. weather list view 화면으로 리다이렉트
		return "redirect:/weather-history/weather-list-view";
	}
}