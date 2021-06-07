package com.ardaatay.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@Column(name = "email")
	@NotBlank
	@NotNull
	private String email;

	@Column(name = "password_hash")
	@NotBlank
	@NotNull
	private String passwordHash;

	@Column(name = "password_salt")
	@NotBlank
	@NotNull
	private String passwordSalt;
	
	@Column(name="activate")
	private Boolean activate;

	public User() {
	}

	public User(int id, String email, String passwordHash, String passwordSalt) {
		this.id = id;
		this.email = email;
		this.passwordHash = passwordHash;
		this.passwordSalt = passwordSalt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getPasswordSalt() {
		return passwordSalt;
	}

	public void setPasswordSalt(String passwordSalt) {
		this.passwordSalt = passwordSalt;
	}
}
