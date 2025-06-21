package com.nt.utils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.model.Report;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ExportPDF extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Report> reports=(List<Report>) model.get("pdf");
		
		// Downloading the pdf file and setting the file name
		response.setHeader("Content-Disposition","attachment;filename=Insurance.pdf");
		
		// Keeping the heading 
		Paragraph heading = new Paragraph();
		heading.add("INSURANCE-REPORT GENERATION");
		
		// creating the table by using Pre-Defined PdfPTable class 
		PdfPTable table = new PdfPTable(6);
		table.addCell("ID");
		table.addCell("Plan-Names");
		table.addCell("Plan-Status");
		table.addCell("Gender");
		table.addCell("StartDate");
		table.addCell("EndDate");
		
		//adding the data into the rows
		for(Report report : reports) {
			table.addCell(String.valueOf(report.getId()));
			table.addCell(report.getPlanName());
			table.addCell(report.getPlanStatus());
			table.addCell(report.getGender());
			table.addCell(report.getStartDate());
			table.addCell(report.getEndDate());
		}
		
		// adding into all the elements into the document
		document.add(heading);
		document.add(table);
		// add the time and data
		document.add(new Paragraph(LocalDateTime.now().toString()));
	}

}
