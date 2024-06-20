package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Realtor;
import com.quiz.lesson04.mapper.RealtorMapper;

@Service
public class RealtorBO {

	private final RealtorMapper realtorMapper;

	@Autowired
	public RealtorBO(RealtorMapper realtorMapper) {
		this.realtorMapper = realtorMapper;
	}

	// input: Realtor, output: X
	public void addRealtor(Realtor reaoltor) {
		realtorMapper.insertRealtor(reaoltor);
	}

	// input: id, output: Realtor
	public Realtor getRealtorById(int id) {
		return realtorMapper.selectRealtorById(id);
	}
}
