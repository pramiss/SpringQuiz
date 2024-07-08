package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07Quiz02RestController {
	
	private RecruitRepository recruitRepository;
	
	public Lesson07Quiz02RestController(RecruitRepository recruitRepository) {
		this.recruitRepository = recruitRepository;
	}
	
	@GetMapping("/1")
	public RecruitEntity select1(
			@RequestParam("id") int id) {
		return recruitRepository.findById(id).orElse(new RecruitEntity());
	}
	
	@GetMapping("/2") // quiz02/2?companyId=1
	public List<RecruitEntity> select2(
			@RequestParam("companyId") int companyId) {
		return recruitRepository.findByCompanyId(companyId);
		// return recruitRepository.findTop2ByCompanyId(companyId);
	}
	
	@GetMapping("/3")
	public List<RecruitEntity> select3() {
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	@GetMapping("/4")
	public List<RecruitEntity> select4() {
		// GreaterThan : >
		// GreaterThanEqual : >=
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}
	
	@GetMapping("/5")
	public List<RecruitEntity> select5() {
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
	@GetMapping("/6")
	public List<RecruitEntity> select6() {
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
	@GetMapping("/7")
	public List<RecruitEntity> select7() {
		return recruitRepository.findByDeadlineSalaryType("2026-04-10", 8100, "정규직");
	}
	
	
	
	
	
}
