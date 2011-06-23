package com.pbs.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pbs.domain.User;

@Repository
@Transactional
public class UserDao extends GenericDao<User>{

	public UserDao() {
		super(User.class);
	}

}
