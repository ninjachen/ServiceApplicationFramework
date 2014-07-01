package com.wonders.frame.core.mybatis.controller;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wonders.frame.core.mybatis.model.User;
import com.wonders.frame.core.mybatis.service.UserService;
import com.wonders.frame.security.CurrentUserHolder;


@Controller
@RequestMapping("/user")
public class MUserController {

//	@Resource private UserService userService;

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
//	@RequestMapping("/my-test")
//	public ModelAndView test() {
//		return new ModelAndView("user/my-test");
//	}
	@RequestMapping("/my-test")
	public String myInformation(ModelMap modelMap) {
		Integer id = CurrentUserHolder.get().getId();
		User u = userService.getUserById(id);
		System.out.println("+++"+u.getFirstName());
//		modelMap.addAttribute("currentUser", userService.getUserById(id));
//		userService.deleteByPrimaryKey(3);
		
		return "#my-test";
	}
	
	
}
