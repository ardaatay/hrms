package com.ardaatay.hrms.business.abstracts;

import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.dtos.ExperienceDto;

public interface ExperienceService {
	Result add(ExperienceDto experinceDto);

	Result deleteById(int id);
}
