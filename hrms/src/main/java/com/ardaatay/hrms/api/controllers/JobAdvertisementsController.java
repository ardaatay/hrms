package com.ardaatay.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ardaatay.hrms.business.abstracts.JobAdvertisementService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.JobAdvertisement;
import com.ardaatay.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping(name = "/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementDto jobAdvertisementDto) {
		return this.jobAdvertisementService.add(jobAdvertisementDto);
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}

	@GetMapping("/getbyactivate")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementByActivate(@RequestParam Boolean activate) {
		return this.jobAdvertisementService.getJobAdvertisementByActivate(activate);
	}

	@GetMapping("/getbyactivateorderbyposteddate")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementByActivateOrderByPostedDate(

			@RequestParam Boolean activate) {
		return this.jobAdvertisementService.getJobAdvertisementByActivateOrderByPostedDate(activate);
	}

	@GetMapping("/getbycompanyandactivate")
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementByCompanyAndActivate(@RequestParam String company,

			@RequestParam Boolean activate) {
		return this.jobAdvertisementService.getJobAdvertisementByCompanyAndActivate(company, activate);
	}

	@PostMapping("/deactivate")
	public Result deactivate(@RequestParam int id) {
		return this.jobAdvertisementService.deactivateJobAdvertisementByActivate(id);
	}
}
