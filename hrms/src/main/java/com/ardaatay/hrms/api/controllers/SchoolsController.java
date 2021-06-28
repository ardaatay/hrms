package com.ardaatay.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardaatay.hrms.business.abstracts.SchoolService;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.dtos.SchoolDto;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin
public class SchoolsController {

	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		this.schoolService = schoolService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody SchoolDto schoolDto) {
		return this.schoolService.add(schoolDto);
	}
}
