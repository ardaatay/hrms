package com.ardaatay.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "job_seeker_resumes")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_id")
	private int id;

	@Column(name = "name")
	@NotBlank
	@NotNull
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "posted_date")
	@Temporal(TemporalType.DATE)
	private Date postedDate;

	@ManyToOne()
	@JoinColumn(name = "job_seeker_id")
	@NotNull
	private JobSeeker jobSeeker;

	@OneToMany(mappedBy = "resume")
	private List<Ability> abilities;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "resume")
	private List<Experience> experiences;

	@OneToMany(mappedBy = "resume")
	private List<School> schools;

	@OneToMany(mappedBy = "resume")
	private List<Language> languages;
}
