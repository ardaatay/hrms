package com.ardaatay.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	private int id;
	private String email;
	private String password;
	private String companyName;
	private String taxNumber;
	private String phone;
	private String webSite;
}
