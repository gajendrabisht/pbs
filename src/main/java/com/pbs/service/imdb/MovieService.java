package com.pbs.service.imdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pbs.dao.imdb.MovieDao;
import com.pbs.domain.imdb.Movie;

@Service
public class MovieService {
	
	private MovieDao movieDao;

	@Autowired
	public MovieService(MovieDao movieDao) {
		this.movieDao = movieDao;
	}

	public List<Movie> getAllMovies() {
		return movieDao.getAllMovies();
	}

}
