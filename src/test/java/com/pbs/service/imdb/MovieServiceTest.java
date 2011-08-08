package com.pbs.service.imdb;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.pbs.dao.imdb.MovieDao;
import com.pbs.domain.imdb.Movie;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {
	
	private MovieService service;
	@Mock MovieDao movieDao;
	
	@Before
	public void setUp() {
		service = new MovieService(movieDao);
	}
	
	@Test
	public void shouldGetAllMovies() {
		// given movies
		List<Movie> allMovies = new ArrayList<Movie>();
		given(movieDao.getAllMovies()).willReturn(allMovies);
		
		// when we get movies
		List<Movie> allMoviesReturned = service.getAllMovies();
		
		// then
		assertThat(allMoviesReturned, sameInstance(allMovies));
	}
	
	@Test
	public void shouldGetAvailableMovies() {
		String movieName = "someMovieName";
		
		List<Movie> availableMovies = new ArrayList<Movie>();
		given(movieDao.getAutoCompleteSuggestedMovies(movieName)).willReturn(availableMovies);
		
		List<Movie> availableMoviesReturned = service.getAutoCompleteSuggestedMovies(movieName);
		
		assertThat(availableMoviesReturned, sameInstance(availableMovies));
	}
	
}
