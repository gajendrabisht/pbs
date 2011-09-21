package com.pbs.controller.sample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {
	
	@RequestMapping(value="/sample/multipleParams")
	public String multipleRequestParams() {
		return "home";
	}
	
	@RequestMapping(value="/sample/multipleParams", params={"action!=one", "action!=two"})
	public String multipleRequestParams2() {
		return "home";
	}

}
