package com.ardaatay.hrms.business.abstracts;

import java.util.List;

import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.Position;
import com.ardaatay.hrms.entities.dtos.DropdownDto;

public interface PositionService {
	DataResult<List<Position>> getAll();

	Result add(Position position);
	
	DataResult<List<DropdownDto>> getDropDown();
}
