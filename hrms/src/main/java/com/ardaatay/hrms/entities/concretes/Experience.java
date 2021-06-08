package com.ardaatay.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resume_experiences")
public class Experience {
	
	@Id
	@GeneratedValue
	@Column(name = "experience_id")
	private int id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "position")
	private String position;

	@Column(name = "start_year")
	private int startYear;
	
	@Column(name = "finish_year")
	private int finishYear;

	@ManyToOne()
	@JoinColumn(name = "resume_id")
	private Resume resume;
}
