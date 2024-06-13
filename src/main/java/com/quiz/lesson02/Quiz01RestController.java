package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@RestController // Spring bean
public class Quiz01RestController {
	
	@Autowired // BI
	private StoreBO storeBO;
	
	// input  X : Client
	// output List<Store> : ResponseBody
	@RequestMapping("/lesson02/quiz01")
	public List<Store> quiz01() { 
		
		// Store Service에 연결해서 List<Store>를 받아옴
		List<Store> storeList = storeBO.getStoreList();
		return storeList;
		
	} 
}
