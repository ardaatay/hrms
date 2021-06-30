package com.ardaatay.hrms.business.abstracts;

import java.util.List;

import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.WorkWay;

public interface WorkWayService {
	Result add(WorkWay workWay);

	DataResult<List<WorkWay>> getAll();
}
