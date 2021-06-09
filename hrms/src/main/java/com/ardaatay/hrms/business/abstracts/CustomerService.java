package com.ardaatay.hrms.business.abstracts;

import java.util.List;

import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.Customer;

public interface CustomerService {
	Result add(Customer employer);
	
	Result activate(String code);
	
	DataResult<List<Customer>> getAll();
}
