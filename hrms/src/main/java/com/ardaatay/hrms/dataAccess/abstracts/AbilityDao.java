package com.ardaatay.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ardaatay.hrms.entities.concretes.Ability;

public interface AbilityDao extends JpaRepository<Ability, Integer> {
}
