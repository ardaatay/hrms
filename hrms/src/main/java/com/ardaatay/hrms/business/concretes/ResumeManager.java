package com.ardaatay.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardaatay.hrms.business.abstracts.ResumeService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.core.utilities.results.SuccessDataResult;
import com.ardaatay.hrms.core.utilities.results.SuccessResult;
import com.ardaatay.hrms.dataAccess.abstracts.ResumeDao;
import com.ardaatay.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;

	@Autowired
	public ResumeManager(ResumeDao resumeDao) {
		this.resumeDao = resumeDao;
	}

	@Override
	public Result add(Resume resume) {
		this.resumeDao.save(resume);
		return new SuccessResult("Kayıt eklendi");
	}

	@Override
	public DataResult<Resume> getResumeById(int id) {
		return new SuccessDataResult<Resume>(this.resumeDao.getResumeById(id), "Data listelendi");
	}

	@Override
	public DataResult<List<Resume>> getResumeByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.getResumeByJobSeeker_Id(jobSeekerId),
				"Data listelendi");
	}

}
