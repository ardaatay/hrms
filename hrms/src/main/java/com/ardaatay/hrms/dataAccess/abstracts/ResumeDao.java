package com.ardaatay.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ardaatay.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {
	Resume getResumeById(int id);

	List<Resume> getResumesByJobSeeker_Id(int jobSeekerId);
}
