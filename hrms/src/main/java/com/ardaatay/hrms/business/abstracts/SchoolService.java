package com.ardaatay.hrms.business.abstracts;

import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.dtos.SchoolDto;

public interface SchoolService {
	Result add(SchoolDto schoolDto);

	Result delete(int id);
}
