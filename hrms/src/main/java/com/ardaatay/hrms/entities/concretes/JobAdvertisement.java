package com.ardaatay.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_advertisements")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "customer", "city", "position", "jobType", "workWay",
		"systemPersonnel" })
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_advertisement_id")
	private int id;

	@Column(name = "job_title")
	@NotBlank
	@NotNull
	private String jobTitle;

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
	private double minSalary;

	@Column(name = "max_salary")
	private double maxSalary;

	@Column(name = "count")
	@NotBlank
	@NotNull
	private int count;

	@Column(name = "last_date")
	@Temporal(TemporalType.DATE)
	private Date lastDate;

	@Column(name = "activate")
	private Boolean activate;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	@NotNull
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "city_id", nullable = false)
	@NotNull
	private City city;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "position_id", nullable = false)
	@NotNull
	private Position position;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "job_type_id", nullable = false)
	@NotNull
	private JobType jobType;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "work_way_id", nullable = false)
	@NotNull
	private WorkWay workWay;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "system_personnel_id", nullable = false)
	@NotNull
	private SystemPersonnel systemPersonnel;
}
