package com.ardaatay.hrms.business.abstracts;

import java.util.List;

import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.entities.concretes.Resume;

public interface ResumeService {
	Result add(Resume resume);

	DataResult<Resume> getResumeById(int id);

	DataResult<List<Resume>> getResumesByJobSeekerId(int jobSeekerId);
}
