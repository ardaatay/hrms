package com.ardaatay.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardaatay.hrms.business.abstracts.ExperienceService;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.core.utilities.results.SuccessResult;
import com.ardaatay.hrms.dataAccess.abstracts.ExperienceDao;
import com.ardaatay.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {
	private ExperienceDao experienceDao;

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(Experience experince) {
		this.experienceDao.save(experince);
		return new SuccessResult("Kayıt yapıldı");
	}

}
