package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.model.Report;

public interface ReportRepository extends JpaRepository<Report, Integer> {

	@Query("SELECT DISTINCT(planName) from Report")
	public List<String> getPlanNames();
	
	@Query("SELECT DISTINCT(planStatus) from Report")
	public List<String> getPlanStatus();
	
}
