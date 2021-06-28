package com.ardaatay.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
	private int id;
	private String name;
	private String department;
	private Double degree;
	private int startYear;
	private int finishYear;
	private int resumeId;
}
