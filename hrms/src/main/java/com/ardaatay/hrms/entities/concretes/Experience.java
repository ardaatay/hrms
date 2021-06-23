package com.ardaatay.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
@Table(name = "resume_experiences")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "resume" })
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "experience_id")
	private int id;

	@Column(name = "name")
	@NotBlank
	@NotNull
	private String name;

	@Column(name = "position")
	@NotBlank
	@NotNull
	private String position;

	@Column(name = "start_year")
	@NotBlank
	@NotNull
	private Integer startYear;

	@Column(name = "finish_year")
	private Integer finishYear;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "resume_id", nullable = false)
	@NotNull
	private Resume resume;
}
