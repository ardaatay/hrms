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

import com.ardaatay.hrms.business.abstracts.ResumeService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin
public class ResumesController {
	private ResumeService resumeService;

	@Autowired
	public ResumesController(ResumeService resumeService) {
		this.resumeService = resumeService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Resume resume) {
		return this.resumeService.add(resume);
	}

	@GetMapping("/getresumebyid")
	public DataResult<Resume> getResumeById(@RequestParam int id) {
		return this.resumeService.getResumeById(id);
	}

	@GetMapping("/getresumesbyjobseekerid")
	public DataResult<List<Resume>> getResumesByJobSeekerId(@RequestParam int jobSeekerId) {
		System.out.println(jobSeekerId);
		return this.resumeService.getResumesByJobSeekerId(jobSeekerId);
	}
}
