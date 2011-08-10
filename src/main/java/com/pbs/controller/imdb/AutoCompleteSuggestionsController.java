package com.pbs.controller.imdb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pbs.domain.User;
import com.pbs.domain.imdb.Movie;
import com.pbs.service.imdb.MovieService;
import com.pbs.service.imdb.UserService;

@Controller
public class AutoCompleteSuggestionsController {

	private final MovieService movieService;
	private final UserService userService;

	@Autowired
	public AutoCompleteSuggestionsController(MovieService movieService, UserService userService) {
		this.movieService = movieService;
		this.userService = userService;
	}
	
	@RequestMapping("/imdb/autocomplete/movies")
	public @ResponseBody List<Movie> getAutoCompleteSuggestedMovies(@RequestParam String movieName) {
		return movieService.getAutoCompleteSuggestedMovies(movieName);
	}
	
	@RequestMapping("/imdb/autocomplete/users")
	public @ResponseBody List<User> getAutoCompleteSuggestedUsers(@RequestParam String userName) {
		return userService.getAutoCompleteSuggestedUsers(userName);
	}
	
}
