package com.ardaatay.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardaatay.hrms.business.abstracts.ResumeService;
import com.ardaatay.hrms.core.utilities.results.DataResult;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.core.utilities.results.SuccessDataResult;
import com.ardaatay.hrms.core.utilities.results.SuccessResult;
import com.ardaatay.hrms.dataAccess.abstracts.ResumeDao;
import com.ardaatay.hrms.entities.concretes.Resume;
import com.ardaatay.hrms.entities.dtos.ResumeDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private ModelMapper modelMapper;

	@Autowired
	public ResumeManager(ResumeDao resumeDao, ModelMapper modelMapper) {
		this.resumeDao = resumeDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(ResumeDto resumeDto) {
		Resume resume = convertToEntity(resumeDto);
		resume.setPostedDate(new Date());
		this.resumeDao.save(resume);
		return new SuccessResult("Kayıt eklendi");
	}

	@Override
	public DataResult<Resume> getResumeById(int id) {
		return new SuccessDataResult<Resume>(this.resumeDao.getResumeById(id), "Data listelendi");
	}

	@Override
	public DataResult<List<Resume>> getResumesByJobSeekerId(int jobSeekerId) {
		return new SuccessDataResult<List<Resume>>(this.resumeDao.getResumesByJobSeeker_Id(jobSeekerId),
				"Data listelendi");
	}

	private Resume convertToEntity(ResumeDto resumeDto) {
		Resume resume = modelMapper.map(resumeDto, Resume.class);
		return resume;
	}
}
