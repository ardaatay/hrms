package com.ardaatay.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ardaatay.hrms.entities.concretes.WorkWay;

public interface WorkWayDao extends JpaRepository<WorkWay, Integer> {

}
