package com.ardaatay.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ardaatay.hrms.entities.concretes.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	Customer getByEmail(String email);
}
