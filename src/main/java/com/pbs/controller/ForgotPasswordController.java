package com.pbs.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pbs.form.object.ForgotPassword;

@Controller
@RequestMapping("/forgotPassword")
public class ForgotPasswordController {

	@RequestMapping(method = RequestMethod.GET)
	public String show(@ModelAttribute ForgotPassword forgotPassword) {
		return "forgotPasswordForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute @Valid ForgotPassword forgotPassword, BindingResult result) {
		if(result.hasErrors()) {
			return show(forgotPassword);
		}
		if(!forgotPassword.getEmail().contains("@gmail.com")) {
			result.rejectValue("email", "NonExistent", new Object[] {"@gmail.com"}, null);
			return show(forgotPassword);
		}
		return "forgotPasswordSubmit";
	}
	
}
