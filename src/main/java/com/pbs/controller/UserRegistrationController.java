package com.pbs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pbs.domain.User;
import com.pbs.service.FormOptionsService;
import com.pbs.service.UserRegistrationService;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {

	private final UserRegistrationService userRegistrationService;
	private final FormOptionsService countryOptionsService;
	
	@Autowired
	public UserRegistrationController(UserRegistrationService userRegistrationService, FormOptionsService countryOptionsService) {
		this.userRegistrationService = userRegistrationService;
		this.countryOptionsService = countryOptionsService;
	}
	
	@ModelAttribute("countryOptions")
	public List<String> getCountryOptions() {
		return countryOptionsService.getCountryOptions();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String showRegistrationForm(@ModelAttribute User user) {
		return "userRegistrationForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String submitRegistrationForm(@ModelAttribute @Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return showRegistrationForm(user);
		}
		userRegistrationService.registerUser(user);
		return "userRegistrationSuccess";
	}

}
