package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson04.domain.Seller;

@Mapper // Spring bean
public interface SellerMapper {
	
	// input:3params, output:rowCount
	public int insertSeller(
			@Param("nickname") String nickname,
			@Param("temperature") Double temperature,
			@Param("profileImageUrl") String profileImageUrl);
	
	public Seller selectSeller();
}
