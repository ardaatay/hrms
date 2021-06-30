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
	private String jobTitle;
	private String description;
	private String requirements;
	private int customerId;
	private String companyName;
	private double minSalary;
	private double maxSalary;
	private int count;
	private Date lastDate;
	private Date postedDate;
	private Boolean activate;
	private int cityId;
	private int jobTypeId;
	private int positionId;
	private int workWayId;
	private int systemPersonnelId;
}
