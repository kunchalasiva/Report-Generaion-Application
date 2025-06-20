package com.nt.service;

import java.util.List;

import com.nt.model.Report;
import com.nt.utils.SearchReport;

public interface ReportService {

	//method to get the list of planNames
	public abstract List<String> getPlanNames();
	
	//method to get the list of planStatus
	public abstract List<String> getPlanStaus();
	
	//method to get the list of all the reports
	public List<Report> getAllReports(Report report);
	
	//method to get the export excel data
	public boolean exportExcel();
	
	//method to get the export PDF data
	public boolean exportPDF();
	
}
