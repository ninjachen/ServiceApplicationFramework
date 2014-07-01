package com.wonders.frame.core.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/common")
public class CommonController {

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("common/login");
	}

}
