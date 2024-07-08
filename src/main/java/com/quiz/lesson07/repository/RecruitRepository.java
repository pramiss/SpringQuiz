package com.quiz.lesson07.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {
	// SQL => DB에 조회

	// JPQL => Entity에 조회
	public List<RecruitEntity> findByCompanyId(int companyId);
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int startSalary, int endSalary);	
	
	// native Query => DB에 sql로 조회
	@Query(value = "SELECT * FROM `recruit` WHERE `deadline` > :deadline AND `salary` >= :salary AND `type` = :type ORDER BY `salary` DESC", nativeQuery = true)
	public List<RecruitEntity> findByDeadlineSalaryType(
			@Param("deadline") String deadline,
			@Param("salary") int salary,
			@Param("type") String type);
	
	// JPQL => Entity에 sql 형식으로 조회
	// @Query(value = "SELECT r FROM RecruitEntity r WHERE WHERE r.deadline > :deadline AND r.salary >= :salary AND r.type = :type ORDER BY r.salary DESC")
}
