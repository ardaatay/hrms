package com.ardaatay.hrms.business.concretes;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardaatay.hrms.business.abstracts.AbilityService;
import com.ardaatay.hrms.core.utilities.results.Result;
import com.ardaatay.hrms.core.utilities.results.SuccessResult;
import com.ardaatay.hrms.dataAccess.abstracts.AbilityDao;
import com.ardaatay.hrms.entities.concretes.Ability;
import com.ardaatay.hrms.entities.dtos.AbilityDto;

@Service
public class AbilityManager implements AbilityService {

	private AbilityDao abilityDao;
	private ModelMapper modelMapper;

	@Autowired
	public AbilityManager(AbilityDao abilityDao, ModelMapper modelMapper) {
		this.abilityDao = abilityDao;
		this.modelMapper = modelMapper;
	}

	@Override
	public Result add(AbilityDto abilityDto) {
		Ability ability = convertToEntity(abilityDto);
		this.abilityDao.save(ability);
		return new SuccessResult("Kayıt yapıldı");
	}

	@Override
	public Result deleteById(int id) {
		this.abilityDao.deleteById(id);
		return new SuccessResult("Kayıt silindi");
	}

	private Ability convertToEntity(AbilityDto abilityDto) {
		Ability ability = modelMapper.map(abilityDto, Ability.class);
		return ability;
	}
}
