package com.pbs.controller.imdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pbs.service.imdb.MovieService;

@Controller
@RequestMapping("/imdb/home")
public class ImdbHomeController {

	private final MovieService movieService;

	@Autowired
	public ImdbHomeController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String showImdbHome(ModelMap modelMap) {
		modelMap.put("allMovies", movieService.getAllMovies());
		return "imdbHomePage";
	}
	
}
