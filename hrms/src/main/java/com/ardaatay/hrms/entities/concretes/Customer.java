package com.ardaatay.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "customers")
public class Customer extends User {

	@Column(name = "company_name", nullable = false)
	@NotBlank
	@NotNull
	private String companyName; 

	@Column(name = "web_site", nullable = false)
	@NotBlank
	@NotNull
	private String webSite;

	@Column(name = "phone", nullable = false)
	@NotBlank
	@NotNull
	private String phone;
	
	@Column(name = "taxNumber", nullable = false)
	@NotBlank
	@NotNull
	private String taxNumber;
	
	@Column(name="activate")
	private Boolean activate;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<JobAdvertisement> jobAdvertisements;

	public Customer() {
	}

	public Customer(int id, String email, String passwordHash, String passwordSalt, String companyName, String webSite,
			String phone,String taxNumber,Boolean activate) {
		super(id, email, passwordHash, passwordSalt);
		this.companyName = companyName;
		this.webSite = webSite;
		this.phone = phone;
		this.taxNumber=taxNumber;
		this.activate=activate;
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

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public Boolean getActivate() {
		return activate;
	}

	public void setActivate(Boolean activate) {
		this.activate = activate;
	}
}
