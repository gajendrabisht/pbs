package com.pbs.dao.imdb;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pbs.dao.GenericDao;
import com.pbs.domain.imdb.Movie;

@Repository
@Transactional
public class MovieDao extends GenericDao<Movie>{

	public MovieDao() {
		super(Movie.class);
	}
	
	public List<Movie> getAllMovies() {
		return sessionFactory.getCurrentSession().createCriteria(Movie.class).addOrder(Order.desc("year")).list();
	}

	public List<Movie> getAutoCompleteSuggestedMovies(String movie) {
		return sessionFactory.getCurrentSession().createCriteria(Movie.class)
												.add(Restrictions.sqlRestriction("lower({alias}.name) like lower(?)", movie + "%", Hibernate.STRING))
												.addOrder(Order.desc("year")).list();
	}

}
