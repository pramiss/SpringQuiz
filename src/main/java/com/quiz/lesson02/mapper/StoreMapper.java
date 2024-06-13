package com.quiz.lesson02.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.quiz.lesson02.domain.Store;

@Mapper // Spring bean by MyBatis
public interface StoreMapper {

	// mapper xml과 연결될 메소드
	// input  X -- from BO
	// output List<Store> -- to BO
	public List<Store> selectStoreList();

}
