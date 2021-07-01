package com.ardaatay.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ardaatay.hrms.entities.concretes.JobType;

public interface JobTypeDao extends JpaRepository<JobType, Integer> {

}
