package com.ardaatay.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardaatay.hrms.business.abstracts.EmployerService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private EmployerService employerService;

	@Autowired
	public EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}

	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
		return this.employerService.getAll();
	}
}