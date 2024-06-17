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
	// mapper 인터페이스가 xml로 파라미터 전송 시 1개만 보낼 수 있다.
	// @Param 어노테이션을 사용하면 파라미터를 하나의 map으로 구성해준다.
	public List<RealEstate> selectRealEstateListByAreaAndPrice(
			@Param("area") int area,
			@Param("price") int price);
	
	// input: RealEstate, output: 성공한 행의 개수(int)
	public int insertRealEstate(RealEstate realEstate);
	
	// input: fields, output: rowCount
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") Integer rentPrice);
}
