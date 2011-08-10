package com.pbs.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pbs.domain.User;

@Repository
@Transactional
public class UserDao extends GenericDao<User>{

	public UserDao() {
		super(User.class);
	}
	
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createCriteria(User.class).addOrder(Order.desc("name")).list();
	}

	public List<User> getAutoCompleteSuggestedUsers(String userName) {
		return sessionFactory.getCurrentSession().createCriteria(User.class)
												.add(Restrictions.sqlRestriction("lower({alias}.name) like lower(?)", userName + "%", Hibernate.STRING))
												.addOrder(Order.desc("name")).list();
	}

}
