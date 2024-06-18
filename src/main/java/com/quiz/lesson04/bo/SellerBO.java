package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service // Spring bean
public class SellerBO {

	private final SellerMapper sellerMapper;
	
	@Autowired
	public SellerBO(SellerMapper sellerMapper) {
		this.sellerMapper = sellerMapper;
	}
	
	// input: 3params, output: rowCount
	public int addSeller(String nickname, Double temperature, String profileImageUrl) {
		return sellerMapper.insertSeller(nickname, temperature, profileImageUrl);
	}
	
	// input: X, output: Seller
	public Seller getSeller() {
		return sellerMapper.selectSeller();
	}
}
