package com.pbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbs.dao.FormOptionsDao;

@Service
public class FormOptionsService {
	
	private final FormOptionsDao formOptionsDao;

	@Autowired
	public FormOptionsService(FormOptionsDao formOptionsDao) {
		this.formOptionsDao = formOptionsDao;
		
	}
	
	public List<String> getCountryOptions() {
		return formOptionsDao.getCountryOptions();
	}

}
