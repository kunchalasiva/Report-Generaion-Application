package com.nt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name="report_tab")
@Data
@Entity
public class Report {

	@Id
	@SequenceGenerator(name = "gen",sequenceName = "REPORTS_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator = "gen",strategy = GenerationType.AUTO)
	private Integer id;
	
	private String planName;
	
	private String planStatus;
	
	private String gender;
	
	private String startDate;
	
	private String endDate;
}
