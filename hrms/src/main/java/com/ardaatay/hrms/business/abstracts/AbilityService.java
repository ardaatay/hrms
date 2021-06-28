package com.ardaatay.hrms.business.abstracts;

import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.dtos.AbilityDto;

public interface AbilityService {
	Result add(AbilityDto abilityDto);
	Result deleteById(int id);
}
