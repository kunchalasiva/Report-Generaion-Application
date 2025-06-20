package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.Report;
import com.nt.repo.ReportRepository;

@Component
public class ReportsUpload implements CommandLineRunner {

    @Autowired
    private ReportRepository repo;

    @Override
    public void run(String... args) throws Exception {

    	repo.deleteAll();
    	
        Report r1 = new Report();
        r1.setPlanName("Health Plan");
        r1.setPlanStatus("Approved");
        r1.setGender("Male");
        r1.setStartDate("2024-01-01");
        r1.setEndDate("2024-06-30");

        Report r2 = new Report();
        r2.setPlanName("Health Plan");
        r2.setPlanStatus("Denied");
        r2.setGender("Female");
        r2.setStartDate(null);
        r2.setEndDate(null);

        Report r3 = new Report();
        r3.setPlanName("Health Plan");
        r3.setPlanStatus("Pending");
        r3.setGender("Male");
        r3.setStartDate("2024-03-01");
        r3.setEndDate("2024-09-30");

        Report r4 = new Report();
        r4.setPlanName("Life Plan");
        r4.setPlanStatus("Approved");
        r4.setGender("Female");
        r4.setStartDate("2024-02-01");
        r4.setEndDate("2024-08-31");

        Report r5 = new Report();
        r5.setPlanName("Life Plan");
        r5.setPlanStatus("Denied");
        r5.setGender("Male");
        r5.setStartDate(null);
        r5.setEndDate(null);

        Report r6 = new Report();
        r6.setPlanName("Life Plan");
        r6.setPlanStatus("Pending");
        r6.setGender("Female");
        r6.setStartDate("2024-04-01");
        r6.setEndDate("2024-10-31");

        Report r7 = new Report();
        r7.setPlanName("Vehicle Plan");
        r7.setPlanStatus("Approved");
        r7.setGender("Male");
        r7.setStartDate("2024-05-01");
        r7.setEndDate("2024-12-31");

        Report r8 = new Report();
        r8.setPlanName("Vehicle Plan");
        r8.setPlanStatus("Denied");
        r8.setGender("Female");
        r8.setStartDate(null);
        r8.setEndDate(null);

        Report r9 = new Report();
        r9.setPlanName("Vehicle Plan");
        r9.setPlanStatus("Pending");
        r9.setGender("Male");
        r9.setStartDate("2024-06-01");
        r9.setEndDate("2024-11-30");

        Report r10 = new Report();
        r10.setPlanName("Health Plan");
        r10.setPlanStatus("Approved");
        r10.setGender("Female");
        r10.setStartDate("2024-01-15");
        r10.setEndDate("2024-07-15");

        Report r11 = new Report();
        r11.setPlanName("Life Plan");
        r11.setPlanStatus("Approved");
        r11.setGender("Male");
        r11.setStartDate("2024-03-01");
        r11.setEndDate("2024-09-30");

        Report r12 = new Report();
        r12.setPlanName("Vehicle Plan");
        r12.setPlanStatus("Pending");
        r12.setGender("Female");
        r12.setStartDate("2024-02-01");
        r12.setEndDate("2024-07-31");
        
        List<Report> list=Arrays.asList(r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12);
        repo.saveAll(list);
        
        System.out.println("12 combinations inserted successfully.");
    }
}
