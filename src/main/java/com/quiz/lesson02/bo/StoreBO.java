package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service // Spring bean
public class StoreBO {
	
	@Autowired // DI
	private StoreMapper storeMapper;

	// input  X -- from Controller
	// output List<Store> -- to Controller
	public List<Store> getStoreList() {

		// mapper 인터페이스 객체에서 List<Store>를 받아옴
		List<Store> storeList = storeMapper.selectStoreList();
		return storeList; 
	} 
	
}
