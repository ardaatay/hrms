package com.ardaatay.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "system_personnels")
public class SystemPersonnel extends User {

	@ManyToOne()
	@JoinColumn(name = "position_id")
	private Position position;

	@OneToMany(mappedBy = "systemPersonnel")
	private List<JobAdvertisement> jobAdvertisements;

	public SystemPersonnel() {
	}

	public SystemPersonnel(int id, String email, String passwordHash, String passwordSalt, int positionId) {
		super(id, email, passwordHash, passwordSalt);
		this.position.setId(positionId);
	}
}
