package com.pbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pbs.dao.FormOptionsDao;

@Service
public class FormOptionsService {
	
	private FormOptionsDao formOptionsDao;

	public FormOptionsService() {
		// For cglib
	}
	
	@Autowired
	public FormOptionsService(FormOptionsDao formOptionsDao) {
		this.formOptionsDao = formOptionsDao;
		
	}
	
	@Cacheable("countryOptions")
	public List<String> getCountryOptions() {
		return formOptionsDao.getCountryOptions();
	}

}
