package com.ardaatay.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardaatay.hrms.business.abstracts.ExperienceService;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {

	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		this.experienceService = experienceService;
	}
	
	@PostMapping("/add")
	public Result add(Experience experience) {
		return this.experienceService.add(experience);
	}
}
