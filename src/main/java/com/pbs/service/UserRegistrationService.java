package com.pbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbs.dao.UserDao;
import com.pbs.domain.User;

@Service
public class UserRegistrationService {
	
	private UserDao userDao;

	@Autowired
	public UserRegistrationService(UserDao userDao) {
		this.userDao = userDao;
	}

	public void registerUser(User user) {
		userDao.save(user);
	}

}
