package com.ardaatay.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ardaatay.hrms.entities.concretes.Position;
import com.ardaatay.hrms.entities.dtos.DropdownDto;

public interface PositionDao extends JpaRepository<Position, Integer> {
	Boolean existsByName(String name);

	@Query("Select new com.ardaatay.hrms.entities.dtos.DropdownDto(p.id,p.name) From Position p")
	List<DropdownDto> getDropdown();
}
