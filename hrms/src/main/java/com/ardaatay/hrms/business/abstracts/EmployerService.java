package com.ardaatay.hrms.business.abstracts;

import java.util.List;

import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.Employer;

public interface EmployerService {
	Result add(Employer employer);
	
	Result activate(String code);
	
	DataResult<List<Employer>> getAll();
}
