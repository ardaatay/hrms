package com.ardaatay.hrms.business.modelMapper;

import org.modelmapper.PropertyMap;

import com.ardaatay.hrms.entities.concretes.Resume;
import com.ardaatay.hrms.entities.dtos.ResumeDto;

public class ResumeMap extends PropertyMap<ResumeDto, Resume> {

	@Override
	protected void configure() {
		map(source.getName(), destination.getName());
		map(source.getDescription(), destination.getDescription());
		map(source.getJobSeekerId(), destination.getJobSeeker());
	}

}
