package com.ardaatay.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDto {
	private String name;
	private String position;
	private int startYear;
	private int finishYear;
	private int resumeId;
}
