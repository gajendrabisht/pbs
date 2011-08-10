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
import com.pbs.service.imdb.UserService;

@RunWith(MockitoJUnitRunner.class)
public class AutoCompleteSuggestionsControllerTest {
	
	private AutoCompleteSuggestionsController controller;
	@Mock private MovieService movieService;
	@Mock private UserService userService;
	
	@Before
	public void setUp() {
		controller = new AutoCompleteSuggestionsController(movieService, userService);
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
