package com.pbs.controller.imdb;

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

import com.pbs.domain.imdb.Movie;
import com.pbs.service.imdb.MovieService;

@RunWith(MockitoJUnitRunner.class)
public class MovieAutoCompleteSuggestionsControllerTest {
	
	private MovieAutoCompleteSuggestionsController controller;
	@Mock private MovieService movieService;
	
	@Before
	public void setUp() {
		controller = new MovieAutoCompleteSuggestionsController(movieService);
	}
	
	@Test
	public void shouldShowImdbHome() {
		String movie = "someMovie";
		List<Movie> availableMovies = new ArrayList<Movie>();
		given(movieService.getAutoCompleteSuggestedMovies(movie)).willReturn(availableMovies);
		
		List<Movie> availableMoviesReturned = controller.getAutoCompleteSuggestedMovies(movie);
		
		assertThat(availableMoviesReturned, sameInstance(availableMovies));
	}
	
 }
