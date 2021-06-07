package com.ardaatay.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardaatay.hrms.business.abstracts.SystemPersonnelService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.SystemPersonnel;

@RestController
@RequestMapping("/api/systempersonnels")
public class SystemPersonnelsController {

	private SystemPersonnelService systemPersonnelService;

	@Autowired
	public SystemPersonnelsController(SystemPersonnelService systemPersonnelService) {
		this.systemPersonnelService = systemPersonnelService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody SystemPersonnel systemPersonnel) {
		return this.systemPersonnelService.add(systemPersonnel);
	}

	@GetMapping("/getall")
	public DataResult<List<SystemPersonnel>> getAll() {
		return this.systemPersonnelService.getAll();
	}
}
