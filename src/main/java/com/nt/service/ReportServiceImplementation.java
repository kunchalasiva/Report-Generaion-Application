package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.model.Report;
import com.nt.repo.ReportRepository;
import com.nt.utils.SearchReport;

@Service
public class ReportServiceImplementation 
				implements ReportService{

	@Autowired
	private ReportRepository repo;
	
	@Override
	public List<String> getPlanNames() {
		return repo.getPlanNames();
	}

	@Override
	public List<String> getPlanStaus() {
		return repo.getPlanStatus();
	}

	@Override
	public List<Report> getAllReports(Report report) {
		 SearchReport search = new SearchReport();
		  
		 search.setGender(report.getGender());
		 search.setStartDate(report.getStartDate());
		 search.setEndDate(report.getEndDate());
		 
		  Report entity = new Report();
		  
		  if(report.getPlanName()!=null && !"".equals(report.getPlanName())) {
		  entity.setPlanName(report.getPlanName());
		  }
		  
		  if(report.getPlanStatus()!=null && !"".equals(report.getPlanStatus())) {
			  entity.setPlanStatus(report.getPlanStatus());
		  }
		 
		  if(search.getGender()!=null && !"".equals(report.getGender())) {
			  entity.setGender(report.getGender());
		  }
		  
		  if(search.getStartDate()!=null && !"".equals(report.getStartDate())) {
			  entity.setStartDate(report.getStartDate());
		  }
		  
		  if(search.getEndDate()!=null && !"".equals(report.getEndDate())) {
			  entity.setEndDate(report.getEndDate());
		  }
		return repo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel() {
		return false;
	}

	@Override
	public boolean exportPDF() {
		return false;
	}

}
