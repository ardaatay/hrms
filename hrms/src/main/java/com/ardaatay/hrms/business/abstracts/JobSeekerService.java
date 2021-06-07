package com.ardaatay.hrms.business.abstracts;

import java.util.List;

import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	Result add(JobSeeker jobSeeker);

	Result activate(String code);

	DataResult<List<JobSeeker>> getAll();
}
