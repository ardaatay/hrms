package com.ardaatay.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resume_abilities")
public class Ability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ability_id")
	private int id;

	@Column(name = "name")
	@NotBlank
	@NotNull
	private String name;

	@Column(name = "description")
	private String description;

	@ManyToOne()
	@JoinColumn(name = "resume_id")
	@NotNull
	private Resume resume;
}
