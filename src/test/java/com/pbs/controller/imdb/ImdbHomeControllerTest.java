package com.pbs.controller.imdb;

import static org.hamcrest.CoreMatchers.is;
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
import org.springframework.ui.ModelMap;

import com.pbs.domain.imdb.Movie;
import com.pbs.service.imdb.MovieService;

@RunWith(MockitoJUnitRunner.class)
public class ImdbHomeControllerTest {
	
	private ImdbHomeController controller;
	@Mock private MovieService movieService;
	
	@Before
	public void setUp() {
		controller = new ImdbHomeController(movieService);
	}
	
	@Test
	public void shouldShowImdbHome() {
		// given
		List<Movie> allMovies = new ArrayList<Movie>();
		given(movieService.getAllMovies()).willReturn(allMovies);
		// when 
		ModelMap modelMap = new ModelMap();
		String view = controller.showImdbHome(modelMap);
		
		// then
		assertThat(view, is("imdbHomePage"));
		assertThat((List<Movie>)modelMap.get("allMovies"), sameInstance(allMovies));
	}
	
 }
