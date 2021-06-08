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
@Table(name = "resume_languages")
public class Language {
	
	@Id
	@GeneratedValue
	@Column(name = "language_id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "level")
	private int level;

	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
}
