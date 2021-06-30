package com.ardaatay.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardaatay.hrms.business.abstracts.CustomerService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.Customer;
import com.ardaatay.hrms.entities.dtos.CustomerDto;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomersController {

	private CustomerService customerService;

	@Autowired
	public CustomersController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CustomerDto customerDto) {
		System.out.println(customerDto);
		return this.customerService.add(customerDto);
	}

	@GetMapping("/getall")
	public DataResult<List<Customer>> getAll() {
		return this.customerService.getAll();
	}
}
