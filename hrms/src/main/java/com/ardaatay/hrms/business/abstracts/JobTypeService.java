package com.ardaatay.hrms.business.abstracts;

import java.util.List;

import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.entities.concretes.JobType;

public interface JobTypeService {
	DataResult<List<JobType>> getAll();
}
