package com.ardaatay.hrms.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardaatay.hrms.business.abstracts.SchoolService;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.core.utilities.results.SuccessResult;
import com.ardaatay.hrms.dataAccess.abstracts.SchoolDao;
import com.ardaatay.hrms.entities.concretes.School;
import com.ardaatay.hrms.entities.dtos.SchoolDto;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	private ModelMapper modelMapper;

	@Autowired
	public SchoolManager(SchoolDao schoolDao, ModelMapper modelMapper) {
		this.schoolDao = schoolDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(SchoolDto schoolDto) {
		School school = convertToEntity(schoolDto);
		this.schoolDao.save(school);
		return new SuccessResult("Kayıt yapıldı");
	}

	private School convertToEntity(SchoolDto schoolDto) {
		School school = modelMapper.map(schoolDto, School.class);
		return school;
	}

}
