package com.ardaatay.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "positions")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Position {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "position_id")
	private int id;

	@Column(name = "name", nullable = false, length = 255)
	@NotBlank
	@NotNull
	private String name;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "position")
	private List<SystemPersonnel> systemPersonnels;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "position")
	private List<JobAdvertisement> jobAdvertisements;
}
