package com.ardaatay.hrms.business.abstracts;

import java.util.List;

import com.ardaatay.hrms.entities.concretes.Position;

public interface PositionService {
	List<Position> getAll();
}
