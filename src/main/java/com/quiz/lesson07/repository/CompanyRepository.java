package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.CompanyEntity;

// '@어노테이션' X 대신 'extends 라이브러리'  -> JpaRepository<Entity 클래스, PK 타입>
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
	// Spring Data JPA Framework
}
