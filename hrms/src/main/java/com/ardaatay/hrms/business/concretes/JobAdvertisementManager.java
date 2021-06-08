package com.ardaatay.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardaatay.hrms.business.abstracts.JobAdvertisementService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.core.utilities.results.SuccessDataResult;
import com.ardaatay.hrms.core.utilities.results.SuccessResult;
import com.ardaatay.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.ardaatay.hrms.entities.concretes.JobAdvertisement;
import com.ardaatay.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Kayıt yapıldı");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Data listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementByActivate(Boolean activate) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertisementDao.getJobAdvertisementByActivate(activate), "Data listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementByActivateOrderByPostedDate(Boolean activate) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertisementDao.getJobAdvertisementByActivateOrderByPostedDate(activate), "Data listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementByCompanyAndActivate(String company,
			Boolean activate) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(
				this.jobAdvertisementDao.getJobAdvertisementByCompanyAndActivate(company, activate), "Data listelendi");
	}

	@Override
	public Result deactivateJobAdvertisementByActivate(int id) {
		this.jobAdvertisementDao.deactivateJobAdvertisementByActivate(id);
		return new SuccessResult("Pasife alındı");
	}

}