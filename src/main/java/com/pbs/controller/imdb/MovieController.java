package com.pbs.controller.imdb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pbs.domain.imdb.Movie;

@Controller
public class MovieController {
	
	@RequestMapping("/imdb/movie/{movie}")
	public String showMovieDetails(@PathVariable Movie movie, ModelMap modelMap) {
		modelMap.put("movie", movie);
		return "imdb/movieDetails";
	}

}
