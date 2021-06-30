package com.ardaatay.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardaatay.hrms.business.abstracts.WorkWayService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.core.utilities.results.SuccessDataResult;
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

	@Override
	public DataResult<List<WorkWay>> getAll() {
		return new SuccessDataResult<List<WorkWay>>(this.workWayDao.findAll(), "Data listelendi");
	}

}
