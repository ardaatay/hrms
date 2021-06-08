package com.ardaatay.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@GeneratedValue
	@Column(name = "position_id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "position")
	private List<SystemPersonnel> systemPersonnels;

	@OneToMany(mappedBy = "position")
	private List<JobAdvertisement> jobAdvertisements;
}
