package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.domain.RealEstate;

@Mapper // Spring bean
public interface RealEstateMapper {

	// input: id(필수), output: RealEstate
	public RealEstate selectRealEstateById(int id);
	
	// input: rentPrice(필수), output: List<RealEstate>
	public List<RealEstate> selectRealEstateListByRentPrice(int rentPrice);
	
	// input: area, price(필수), output: List<RealEstate>
	public List<RealEstate> selectRealEstateListByAreaAndPrice(@Param("area") int area, @Param("price") int price);
}
