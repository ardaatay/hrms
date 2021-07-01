package com.ardaatay.hrms.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardaatay.hrms.business.abstracts.ExperienceService;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.core.utilities.results.SuccessResult;
import com.ardaatay.hrms.dataAccess.abstracts.ExperienceDao;
import com.ardaatay.hrms.entities.concretes.Experience;
import com.ardaatay.hrms.entities.dtos.ExperienceDto;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;
	private ModelMapper modelMapper;

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao, ModelMapper modelMapper) {
		this.experienceDao = experienceDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(ExperienceDto experinceDto) {
		Experience experience = convertToEntity(experinceDto);
		this.experienceDao.save(experience);
		return new SuccessResult("Kayıt yapıldı");
	}

	@Override
	public Result deleteById(int id) {
		this.experienceDao.deleteById(id);
		return new SuccessResult("Kayıt silindi");
	}

	private Experience convertToEntity(ExperienceDto experienceDto) {
		Experience experience = modelMapper.map(experienceDto, Experience.class);
		return experience;
	}
}
