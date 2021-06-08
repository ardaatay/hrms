package com.ardaatay.hrms.business.abstracts;

import java.util.List;

import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
}
