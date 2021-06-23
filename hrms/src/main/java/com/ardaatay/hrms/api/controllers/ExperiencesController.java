package com.ardaatay.hrms.api.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardaatay.hrms.business.abstracts.ExperienceService;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.Experience;
import com.ardaatay.hrms.entities.dtos.ExperienceDto;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin
public class ExperiencesController {

	private ExperienceService experienceService;
	private ModelMapper modelMapper;

	@Autowired
	public ExperiencesController(ExperienceService experienceService, ModelMapper modelMapper) {
		this.experienceService = experienceService;
		this.modelMapper = modelMapper;
	}

	@PostMapping("/add")
	public Result add(@RequestBody ExperienceDto experienceDto) {
		System.out.println(experienceDto);
		Experience experience = convertToEntity(experienceDto);
		return this.experienceService.add(experience);
	}

	private Experience convertToEntity(ExperienceDto experienceDto) {
		Experience experience = modelMapper.map(experienceDto, Experience.class);
		return experience;
	}
}
