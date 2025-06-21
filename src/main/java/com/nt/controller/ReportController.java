package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Report;
import com.nt.service.ReportServiceImplementation;
import com.nt.utils.ExportExcelData;
import com.nt.utils.ExportPDF;

@Controller
public class ReportController {

    @Autowired
    private ReportServiceImplementation service;

    @GetMapping("/")
    public String homepage(Model model) {
        model.addAttribute("report", new Report());  
        List<String> names = service.getPlanNames();
        List<String> status = service.getPlanStaus();

        model.addAttribute("planname", names);
        model.addAttribute("planstatus", status);
        return "home";
    }

    @PostMapping("/search")
    public String filterReports(@ModelAttribute("report") Report report, RedirectAttributes redirectAttributes) {
        List<Report> filterresults = service.getAllReports(report);
        redirectAttributes.addFlashAttribute("reports", filterresults);
        redirectAttributes.addFlashAttribute("report", new Report()); 
        return "redirect:/";
    }
    
    @GetMapping("/excel")
    public ModelAndView exportExcel() {
    	// use the service
    	ModelAndView modelandview = new ModelAndView();
    	List<Report> excel=service.exportExcel();
    	return new ModelAndView(new ExportExcelData(),"excel",excel);
    }
    @GetMapping("/pdf")
    public ModelAndView exportPDF() {
    	// use the service
    	ModelAndView modelandview = new ModelAndView();
    	List<Report> pdf=service.exportPDF();
    	System.out.println(pdf);
    	return new ModelAndView(new ExportPDF(),"pdf",pdf);
    }
}
