package com.ardaatay.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ardaatay.hrms.business.abstracts.PositionService;
import com.ardaatay.hrms.entities.concretes.Position;

@RestController
@RequestMapping("/api/positions")
public class PositionsController {

	private PositionService positionService;

	@Autowired
	public PositionsController(PositionService positionService) {
		this.positionService = positionService;
	}

	@GetMapping("/getall")
	public List<Position> getAll() {
		return this.positionService.getAll();
	}

}