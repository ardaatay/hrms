package com.ardaatay.hrms.business.abstracts;

import java.util.List;

import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	Result add(SystemPersonnel systemPersonnel);

	DataResult<List<SystemPersonnel>> getAll();
}
