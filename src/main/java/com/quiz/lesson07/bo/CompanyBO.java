package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {

	@Autowired
	private CompanyRepository companyRepository;
	
	// INSERT, input: params, output: CompanyEntity (방금 넣은거)
	public CompanyEntity addCompany(String name,
			String business, String scale, int headcount) {

		return companyRepository.save(
				CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build());
	}
	
	// UPDATE, input: id, scale, headcount, output: CompanyE or null
	public CompanyEntity updateCompanyScaleAndHeadcountById(int id, String scale, int headcount) {
		// 1. update할 튜플 가져오기 -> entity에 저장
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		
		// 2. entity 수정
		// 3. entity 다시 저장
		if (company != null) {
			company = companyRepository.save(company.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build());
		}
		
		return company; // entity or null
	} //-- UPDATE
	
	// DELETE, input: id, output: x
	public void deleteCompanyById(int id) {
		// 1. 해당하는 entity를 가져옴
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		// 2. optional 람다식으로 삭제
		companyOptional.ifPresent(c -> companyRepository.delete(c));
	}
}
