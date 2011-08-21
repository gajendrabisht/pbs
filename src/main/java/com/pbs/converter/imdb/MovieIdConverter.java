package com.pbs.converter.imdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.pbs.dao.imdb.MovieDao;
import com.pbs.domain.imdb.Movie;

@Component
public class MovieIdConverter implements Converter<String, Movie>{

	private final MovieDao movieDao;

	@Autowired
	public MovieIdConverter(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	
	public Movie convert(String movieId) {
		return movieDao.get(Long.parseLong(movieId));
	}

}
