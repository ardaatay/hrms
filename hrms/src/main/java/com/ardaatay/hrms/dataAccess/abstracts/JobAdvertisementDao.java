package com.ardaatay.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ardaatay.hrms.entities.concretes.JobAdvertisement;
import com.ardaatay.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("Select new com.ardaatay.hrms.entities.dtos.JobAdvertisementDto(j.id,j.companyName,j.jobTitle,j.count,j.postedDate,j.lastDate) From JobAdvertisement j where activate=:activate")
	List<JobAdvertisementDto> getJobAdvertisementByActivate(Boolean activate);

	@Query("Select new com.ardaatay.hrms.entities.dtos.JobAdvertisementDto(j.id,j.companyName,j.jobTitle,j.count,j.postedDate,j.lastDate) From JobAdvertisement j where activate=:activate order by j.postedDate")
	List<JobAdvertisementDto> getJobAdvertisementByActivateOrderByPostedDate(Boolean activate);

	@Query("Select new com.ardaatay.hrms.entities.dtos.JobAdvertisementDto(j.id,j.companyName,j.jobTitle,j.count,j.postedDate,j.lastDate) From JobAdvertisement j where company=:company and activate=:activate")
	List<JobAdvertisementDto> getJobAdvertisementByCompanyAndActivate(String company, Boolean activate);

	@Modifying
	@Query("Update JobAdvertisement j set j.activate = false where j.id =:id")
	void deactivateJobAdvertisementByActivate(@Param("id") int id);
}
