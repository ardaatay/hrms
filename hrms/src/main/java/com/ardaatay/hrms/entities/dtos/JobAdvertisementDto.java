package com.ardaatay.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
	private int id;
	private String companyName;
	private String jobTitle;
	private int count;
	private Date postedDate;
	private Date lastDate;

}
