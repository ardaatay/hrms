package com.ardaatay.hrms.business.abstracts;

import java.util.List;

import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.Customer;
import com.ardaatay.hrms.entities.dtos.CustomerDto;

public interface CustomerService {
	Result add(CustomerDto customerDto);

	Result activate(String code);

	DataResult<Customer> getById(int id);

	DataResult<List<Customer>> getAll();
}
