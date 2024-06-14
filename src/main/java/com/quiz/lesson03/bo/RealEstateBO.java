package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service // Spring bean
public class RealEstateBO {

	// DI
	private final RealEstateMapper realEstateMapper;
	
	@Autowired
	public RealEstateBO(RealEstateMapper realEstateMapper) {
		this.realEstateMapper = realEstateMapper;
	}

	// method
	// input: id(필수), output: RealEstate
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	// input: rentPrice(필수), output: List<RealEstate>
	public List<RealEstate> getRealEstateListByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateListByRentPrice(rentPrice);
	}
}
