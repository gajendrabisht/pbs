package com.pbs.service.imdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbs.dao.UserDao;
import com.pbs.domain.User;

@Service
public class UserService {
	
	private final UserDao userDao;

	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User getUser(Long id) {
		return userDao.get(id);
	}
	
	public List<User> getAutoCompleteSuggestedUsers(String userName) {
		return userDao.getAutoCompleteSuggestedUsers(userName);
	}

}
