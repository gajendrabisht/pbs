package com.pbs.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class GenericDao<E> {
	
	private Class<E> type;
	protected SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public GenericDao(Class<E> type) {
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	public E get(Long id) {
		return (E) sessionFactory.getCurrentSession().get(type, id);
	}

	public void save(E element) {
		sessionFactory.getCurrentSession().save(element);
	}

	public void delete(E element) {
		sessionFactory.getCurrentSession().delete(element);
	}

	public void update(E element) {
		sessionFactory.getCurrentSession().update(element);
	}

}
