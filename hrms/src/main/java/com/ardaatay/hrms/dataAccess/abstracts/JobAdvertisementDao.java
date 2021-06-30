package com.ardaatay.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ardaatay.hrms.entities.concretes.JobAdvertisement;
import com.ardaatay.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("Select new com.ardaatay.hrms.entities.dtos.JobAdvertisementDto(j.id,j.jobTitle,j.description,j.requirements,c.id as customerId,c.companyName,j.minSalary,j.maxSalary,j.count,j.lastDate,j.postedDate,j.activate,cty.id as cityId,jt.id as jobTypeId,p.id as positionId,w.id as workWayId,sp.id as systemPersonnelId) From JobAdvertisement j Join j.customer c Join j.city cty Join j.jobType jt Join j.position p Join j.workWay w Join j.systemPersonnel sp where j.activate=:activate")
	List<JobAdvertisementDto> getJobAdvertisementByActivate(Boolean activate);

	@Query("Select new com.ardaatay.hrms.entities.dtos.JobAdvertisementDto(j.id,j.jobTitle,j.description,j.requirements,c.id as customerId,c.companyName,j.minSalary,j.maxSalary,j.count,j.lastDate,j.postedDate,j.activate,cty.id as cityId,jt.id as jobTypeId,p.id as positionId,w.id as workWayId,sp.id as systemPersonnelId) From JobAdvertisement j Join j.customer c Join j.city cty Join j.jobType jt Join j.position p Join j.workWay w Join j.systemPersonnel sp where j.activate=:activate order by j.postedDate")
	List<JobAdvertisementDto> getJobAdvertisementByActivateOrderByPostedDate(Boolean activate);

	@Query("Select new com.ardaatay.hrms.entities.dtos.JobAdvertisementDto(j.id,j.jobTitle,j.description,j.requirements,c.id as customerId,c.companyName,j.minSalary,j.maxSalary,j.count,j.lastDate,j.postedDate,j.activate,cty.id as cityId,jt.id as jobTypeId,p.id as positionId,w.id as workWayId,sp.id as systemPersonnelId) From JobAdvertisement j Join j.customer c Join j.city cty Join j.jobType jt Join j.position p Join j.workWay w Join j.systemPersonnel sp where c.companyName=:companyName and j.activate=:activate")
	List<JobAdvertisementDto> getJobAdvertisementByCompanyAndActivate(String companyName, Boolean activate);

	@Modifying
	@Query("Update JobAdvertisement j set j.activate = false where j.id =:id")
	void deactivateJobAdvertisementByActivate(@Param("id") int id);

}
