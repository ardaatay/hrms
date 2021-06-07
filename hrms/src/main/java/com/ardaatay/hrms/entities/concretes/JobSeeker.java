package com.ardaatay.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "job_seekers")
public class JobSeeker extends User {

	
	@Column(name = "first_name")
	@NotBlank
	@NotNull
	private String firstName;

	@Column(name = "last_name")
	@NotBlank
	@NotNull
	private String lastName;

	@Column(name = "nationality_id")
	@NotBlank
	@NotNull
	private String nationalityId;

	@Column(name = "year_of_birth")
	@NotBlank
	@NotNull
	private int yearOfBirth;

	public JobSeeker() {
	}

	public JobSeeker(int id, String email, String passwordHash, String passwordSalt, String firstName, String lastName,
			String nationalityId, int yearOfBirth) {
		super(id, email, passwordHash, passwordSalt);
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalityId = nationalityId;
		this.yearOfBirth = yearOfBirth;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalityId() {
		return nationalityId;
	}

	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
}
