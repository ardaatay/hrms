package com.ardaatay.hrms.business.abstracts;

import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.dtos.LanguageDto;

public interface LanguageService {
	Result add(LanguageDto languageDto);
	Result deleteById(int id);
}
