package com.wonders.frame.core.jpa.controller;

import java.util.Locale;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.wonders.frame.core.jpa.domain.User;
import com.wonders.frame.core.jpa.service.UserService;
import com.wonders.frame.form.ChangePasswordForm;
import com.wonders.frame.form.UserInformationForm;
import com.wonders.frame.pageable.SimplePageableImpl;
import com.wonders.frame.security.CurrentUserHolder;

import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource private UserService userService;
	@Resource private MessageSource messageSource;

	@RequestMapping("/my-information")
	public String myInformation(ModelMap modelMap) {
		Integer id = CurrentUserHolder.get().getId();
		modelMap.addAttribute("currentUser", userService.findUserById(id));
		
		return "#my-information";
	}
	
	@RequestMapping(value = "/edit-information", method = {RequestMethod.GET})
	public String editInformation(ModelMap modelMap) {
		Integer id = CurrentUserHolder.get().getId();
		User current = userService.findUserById(id);
		UserInformationForm form = new UserInformationForm();
		form.setEmails(current.getEmails());
		form.setLastName(current.getLastName());
		form.setFirstName(current.getFirstName());
		form.setGender(current.getGender() == User.Gender.MALE ? "男" : "女");
		
		modelMap.addAttribute("userInformationForm", form);
		
		return "#edit-information";
	}

	@RequestMapping(value = "/edit-information", method = {RequestMethod.POST})
	public String editInformation(
			@ModelAttribute("userInformationForm") @Valid UserInformationForm form, 
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "#edit-information";
		}
		User user = form.toUser();
		user.setId(CurrentUserHolder.get().getId());
		
		userService.changeInfomations(user);
		
		return "redirect:/user/my-information";
	}
	
	@RequestMapping(value = "/change-password", method = {RequestMethod.GET})
	public String changePassword(ModelMap modelMap) {
		modelMap.addAttribute("changePasswordForm", new ChangePasswordForm());
		return "#change-password";
	}

	@RequestMapping(value = "/change-password", method = {RequestMethod.POST})
	public String changePassword(
			@Valid @ModelAttribute("changePasswordForm") ChangePasswordForm form,
			BindingResult bindingResult,
			ModelMap modelMap)
	{
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("hasErrors", true);
			return "#change-password";
		}

		if (! form.getPassword1().equals(form.getPassword2())) {
			bindingResult.reject("jsr303.changepassword.fail");
		}

		if (! userService.exists(CurrentUserHolder.getId(), form.getOldPassword())) {
			bindingResult.reject("jsr303.changepassword.oldpwd");
		}

		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("hasErrors", true);
			return "#change-password";
		} else {
			userService.changePassword(CurrentUserHolder.getId(), form.getPassword1());
		}

		return "redirect:/user/my-information";
	}

	@RequestMapping(value = "/list-users/{pageNumber}", method = {RequestMethod.GET})
	public ModelAndView listUsers(@PathVariable("pageNumber") Integer pageNumber) {
		Page<User> page = userService.findAll(SimplePageableImpl.getInstance(pageNumber));
		ModelAndView mav = new ModelAndView("#list-users");
		mav.addObject("page", page);
		return mav;
	}

	@RequestMapping(value = "/lock/{userId}/current-page/{currentPageNumber}")
	public String lock(
			@PathVariable("userId") int userId, 
			@PathVariable("currentPageNumber") int currentPageNumber,
			Locale locale) {

		if (userService.hasRole(userId, "ROLE_ADMIN")) {
			String msg = messageSource.getMessage("jsr303.lockuser.fail", null, locale);
			throw new AccessDeniedException(msg);
		}

		userService.lock(userId);
		return "redirect:/user/list-users/" + currentPageNumber;
	}
	
	@RequestMapping(value = "/unlock/{userId}/current-page/{currentPageNumber}")
	public String unlock(
			@PathVariable("userId") int userId, 
			@PathVariable("currentPageNumber") int currentPageNumber,
			Locale locale) {

		if (userService.hasRole(userId, "ROLE_ADMIN")) {
			String msg = messageSource.getMessage("jsr303.lockuser.fail", null, locale);
			throw new AccessDeniedException(msg);
		}

		userService.unlock(userId);
		return "redirect:/user/list-users/" + currentPageNumber;
	}
}
