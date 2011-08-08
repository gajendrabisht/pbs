package com.pbs.controller.imdb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pbs.domain.imdb.DummyMovie;
import com.pbs.domain.imdb.Movie;
import com.pbs.service.imdb.MovieService;

@Controller
public class MovieAutoCompleteSuggestionsController {

	private final MovieService movieService;

	@Autowired
	public MovieAutoCompleteSuggestionsController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@RequestMapping("/imdb/autocompletesuggestedmovies")
	public @ResponseBody List<Movie> getAutoCompleteSuggestedMovies(@RequestParam String movieName) {
		return movieService.getAutoCompleteSuggestedMovies(movieName);
	}
	
	@RequestMapping("/imdb/testingJson")
	public @ResponseBody List<DummyMovie> testingJson(@RequestParam String movieName) {
		List<DummyMovie> movies = new ArrayList<DummyMovie>();
		movies.add(new DummyMovie("id1", "movie1"));
		movies.add(new DummyMovie("id2", "movie2"));
		return movies;
	}
	
	@RequestMapping("/imdb/testingJson2")
	public @ResponseBody String[] testingJson2(@RequestParam String movieName) {
		return new String[] {"hello", "there"};
	}
	
}
