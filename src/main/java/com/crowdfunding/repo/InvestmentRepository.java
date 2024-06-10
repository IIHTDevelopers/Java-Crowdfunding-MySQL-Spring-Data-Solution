package com.crowdfunding.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crowdfunding.entity.Investment;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
	List<Investment> findByProjectId(Long projectId);

	List<Investment> findByInvestorName(String investorName);

	@Query("SELECT i FROM Investment i WHERE i.project.id = :projectId")
	List<Investment> findInvestmentsByProjectId(Long projectId);
}
