package com.ardaatay.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardaatay.hrms.business.abstracts.PositionService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.ErrorResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.core.utilities.results.SuccessDataResult;
import com.ardaatay.hrms.core.utilities.results.SuccessResult;
import com.ardaatay.hrms.dataAccess.abstracts.PositionDao;
import com.ardaatay.hrms.entities.concretes.Position;
import com.ardaatay.hrms.entities.dtos.DropdownDto;

@Service
public class PositionManager implements PositionService {

	private PositionDao positionDao;

	@Autowired
	public PositionManager(PositionDao positionDao) {
		this.positionDao = positionDao;
	}

	@Override
	public DataResult<List<Position>> getAll() {
		return new SuccessDataResult<List<Position>>(this.positionDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Position position) {

		if (this.positionDao.existsByName(position.getName())) {
			return new ErrorResult("Bu pozisyon daha önce kayıt edilmiş");
		}

		this.positionDao.save(position);
		return new SuccessResult("Pozisyonlar eklendi");
	}

	@Override
	public DataResult<List<DropdownDto>> getDropDown() {
		return new SuccessDataResult<List<DropdownDto>>(this.positionDao.getDropdown(), "Data listelendi");
	}

}
