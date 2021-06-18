package com.ardaatay.hrms.business.abstracts;

import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.Experience;

public interface ExperienceService {
	Result add(Experience experince);
}
