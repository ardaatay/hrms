package com.ardaatay.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardaatay.hrms.business.abstracts.WorkWayService;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.core.utilities.results.SuccessResult;
import com.ardaatay.hrms.dataAccess.abstracts.WorkWayDao;
import com.ardaatay.hrms.entities.concretes.WorkWay;

@Service
public class WorkWayManager implements WorkWayService {

	private WorkWayDao workWayDao;

	@Autowired
	public WorkWayManager(WorkWayDao workWayDao) {
		this.workWayDao = workWayDao;
	}

	@Override
	public Result add(WorkWay workWay) {
		this.workWayDao.save(workWay);
		return new SuccessResult("Kayıt yapıldı.");
	}

}
