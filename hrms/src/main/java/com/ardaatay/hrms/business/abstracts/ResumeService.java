package com.ardaatay.hrms.business.abstracts;

import java.util.List;

import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.Resume;
import com.ardaatay.hrms.entities.dtos.ResumeDto;

public interface ResumeService {
	Result add(ResumeDto resumeDto);

	DataResult<Resume> getResumeById(int id);

	DataResult<List<Resume>> getResumesByJobSeekerId(int jobSeekerId);
}
