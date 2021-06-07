package com.ardaatay.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employers")
public class Employer extends User {

	@Column(name = "company_name")
	@NotBlank
	@NotNull
	private String companyName;

	@Column(name = "web_site")
	@NotBlank
	@NotNull
	private String webSite;

	@Column(name = "phone")
	@NotBlank
	@NotNull
	private String phone;

	public Employer() {
	}

	public Employer(int id, String email, String passwordHash, String passwordSalt, String companyName, String webSite,
			String phone) {
		super(id, email, passwordHash, passwordSalt);
		this.companyName = companyName;
		this.webSite = webSite;
		this.phone = phone;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
