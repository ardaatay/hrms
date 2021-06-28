package com.ardaatay.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ardaatay.hrms.business.abstracts.AbilityService;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.dtos.AbilityDto;

@RestController
@RequestMapping("/api/abilities")
@CrossOrigin
public class AbilitiesController {

	private AbilityService abilityService;

	@Autowired
	public AbilitiesController(AbilityService abilityService) {
		this.abilityService = abilityService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody AbilityDto abilityDto) {
		return this.abilityService.add(abilityDto);
	}

	@DeleteMapping("/delete")
	public Result add(@RequestParam int id) {
		return this.abilityService.deleteById(id);
	}
}
