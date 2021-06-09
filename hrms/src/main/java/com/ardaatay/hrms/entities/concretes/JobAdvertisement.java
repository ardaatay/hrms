package com.ardaatay.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_advertisements")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_advertisement_id")
	private int id;

	@Column(name = "job_title")
	@NotBlank
	@NotNull
	private String jobTitle;

	@Column(name = "company")
	@NotBlank
	@NotNull
	private String company;

	@Column(name = "description")
	private String description;

	@Column(name = "requirements")
	@NotBlank
	@NotNull
	private String requirements;

	@Column(name = "posted_date")
	@Temporal(TemporalType.DATE)
	private Date postedDate;

	@Column(name = "min_salary")
	private int minSalary;

	@Column(name = "max_salary")
	private int maxSalary;

	@Column(name = "count")
	@NotBlank
	@NotNull
	private int count;

	@Column(name = "last_date")
	@Temporal(TemporalType.DATE)
	private Date lastDate;

	@Column(name = "activate")
	private Boolean activate;

	@ManyToOne()
	@JoinColumn(name = "city_id")
	@NotNull
	private City city;

	@ManyToOne()
	@JoinColumn(name = "position_id")
	@NotNull
	private Position position;
}
