package com.ardaatay.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ardaatay.hrms.business.abstracts.ExperienceService;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.dtos.ExperienceDto;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin
public class ExperiencesController {

	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		this.experienceService = experienceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody ExperienceDto experienceDto) {
		return this.experienceService.add(experienceDto);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return this.experienceService.deleteById(id);
	}
}
