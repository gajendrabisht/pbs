package com.pbs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pbs.domain.CountryOption;

@Repository
@Transactional
public class FormOptionsDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getCountryOptions() {
		return (List<String>) sessionFactory.getCurrentSession().createCriteria(CountryOption.class)
									.setProjection(Projections.property("name"))
									.addOrder(Order.asc("name"))
									.list();
	}

}
