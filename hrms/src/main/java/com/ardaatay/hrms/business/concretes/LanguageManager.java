package com.ardaatay.hrms.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardaatay.hrms.business.abstracts.LanguageService;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.core.utilities.results.SuccessResult;
import com.ardaatay.hrms.dataAccess.abstracts.LanguageDao;
import com.ardaatay.hrms.entities.concretes.Language;
import com.ardaatay.hrms.entities.dtos.LanguageDto;

@Service
public class LanguageManager implements LanguageService {

	private LanguageDao languageDao;
	private ModelMapper modelMapper;

	@Autowired
	public LanguageManager(LanguageDao languageDao, ModelMapper modelMapper) {
		this.languageDao = languageDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(LanguageDto languageDto) {
		Language language = convertToEntity(languageDto);
		this.languageDao.save(language);
		return new SuccessResult("Kayıt yapıldı");
	}

	private Language convertToEntity(LanguageDto languageDto) {
		Language language = modelMapper.map(languageDto, Language.class);
		return language;
	}

}
