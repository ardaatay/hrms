package com.ardaatay.hrms.business.abstracts;

import java.util.List;

import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.JobAdvertisement;
import com.ardaatay.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);

	DataResult<List<JobAdvertisement>> getAll();

	DataResult<List<JobAdvertisementDto>> getJobAdvertisementByActivate(Boolean activate);

	DataResult<List<JobAdvertisementDto>> getJobAdvertisementByActivateOrderByPostedDate(Boolean activate);

	DataResult<List<JobAdvertisementDto>> getJobAdvertisementByCompanyAndActivate(String company, Boolean activate);

	Result deactivateJobAdvertisementByActivate(int id);
}
