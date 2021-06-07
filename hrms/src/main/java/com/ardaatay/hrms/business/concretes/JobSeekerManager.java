package com.ardaatay.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardaatay.hrms.business.abstracts.JobSeekerService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.ErrorResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.core.utilities.results.SuccessDataResult;
import com.ardaatay.hrms.core.utilities.results.SuccessResult;
import com.ardaatay.hrms.core.utilities.verification.EmailVerification;
import com.ardaatay.hrms.core.utilities.verification.Verification;
import com.ardaatay.hrms.dataAccess.abstracts.JobSeekerDao;
import com.ardaatay.hrms.entities.concretes.JobSeeker;
import com.ardaatay.hrms.mernis.MernisManager;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {

		MernisManager mernisManager = new MernisManager();
		if (!mernisManager.tcKimlikNoDogrula(jobSeeker.getNationalityId())) {
			return new ErrorResult("Tc No Hatalı!");
		}

		JobSeeker checkJobSeeker = this.jobSeekerDao.getByEmailOrNationalityId(jobSeeker.getEmail(),
				jobSeeker.getNationalityId());
		if (checkJobSeeker != null) {
			return new ErrorResult("Bu email veya tcNo kayıtlıdır.");
		}

		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("İş arayan eklendi.");
	}

	@Override
	public Result activate(String code) {
		Verification verification = new EmailVerification();
		if (verification.run(code)) {
			return new SuccessResult("Doğrulama başarılı");
		}

		return new ErrorResult("Doğrulama başarısız");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Data Listelendi");
	}

}
