package com.pbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(ModelMap modelMap) {
		modelMap.addAttribute("name", "Gajendra Bisht");
		return "home";
	}
	
}

