package com.ardaatay.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardaatay.hrms.business.abstracts.CityService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {

	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService = cityService;
	}

	@GetMapping("/getall")
	public DataResult<List<City>> getAll() {
		return this.cityService.getAll();
	}
}
