package com.ardaatay.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardaatay.hrms.business.abstracts.WorkWayService;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.WorkWay;

@RestController
@RequestMapping("/api/workways")
@CrossOrigin
public class WorkWaysController {
	private WorkWayService workWayService;

	@Autowired
	public WorkWaysController(WorkWayService workWayService) {
		this.workWayService = workWayService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody WorkWay workWay) {
		return this.workWayService.add(workWay);
	}
}
