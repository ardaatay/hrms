package com.ardaatay.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardaatay.hrms.business.abstracts.CustomerService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.Customer;

@RestController
@RequestMapping("/api/employers")
public class CustomersController {

	private CustomerService employerService;

	@Autowired
	public CustomersController(CustomerService employerService) {
		this.employerService = employerService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Customer employer) {
		return this.employerService.add(employer);
	}

	@GetMapping("/getall")
	public DataResult<List<Customer>> getAll() {
		return this.employerService.getAll();
	}
}
