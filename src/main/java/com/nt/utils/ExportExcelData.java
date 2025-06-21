package com.nt.utils;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.nt.model.Report;
import com.nt.service.ReportService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExportExcelData extends AbstractXlsxView{

	@Autowired
	private ReportService service;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// giving the file name downloading the file by default
		response.setHeader("Content-Disposition", "attachment;filename=InsuranceReportGeneration.Xls");
		
		 // getting the Reports Data from the model 
			List<Report> list=(List<Report>) model.get("excel");
		
			Sheet sheet=workbook.createSheet("Insurace-Report Generation");
			
			// creating the header row
			Row row=sheet.createRow(0);
			row.createCell(0).setCellValue("ID");
			row.createCell(1).setCellValue("PlanNames");
			row.createCell(2).setCellValue("PlanStatus");
			row.createCell(3).setCellValue("Gender");
			row.createCell(4).setCellValue("StartDate");
			row.createCell(5).setCellValue("EndDate");
			
			// already one row created for headers with index 0th row
			int rownumber=1;
			
			// set the values in the each row
			for(Report report : list ) {
				// creating the rows based on the size of the collection.
				Row r = sheet.createRow(rownumber++);
				r.createCell(0).setCellValue(String.valueOf(report.getId()));
				r.createCell(1).setCellValue(report.getPlanName());
				r.createCell(2).setCellValue(report.getPlanStatus());
				r.createCell(3).setCellValue(report.getGender());
				r.createCell(4).setCellValue(report.getStartDate());
				r.createCell(5).setCellValue(report.getEndDate());
			}
	}

}
