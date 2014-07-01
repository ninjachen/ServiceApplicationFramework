package com.wonders.frame.core.jpa.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.wonders.frame.core.jpa.domain.Contact;
import com.wonders.frame.core.jpa.domain.Group;
import com.wonders.frame.core.jpa.service.ContactService;
import com.wonders.frame.exception.NonEmptyGroupException;
import com.wonders.frame.form.AddContactForm;
import com.wonders.frame.form.AddGroupForm;
import com.wonders.frame.pageable.SimplePageableImpl;
import com.wonders.frame.security.CurrentUserHolder;

import org.springframework.data.domain.Page;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/contact")
@SessionAttributes({"genderOptions"})
public class ContactController {

	@Resource private ContactService contactService;
	
	@ModelAttribute("genderOptions")
	public List<String> getGenderOptions() {
		return Arrays.asList("MALE", "FEMALE");
	}
	
	@RequestMapping(value = "/list-groups", method = {RequestMethod.GET})
	public String listGroups(ModelMap modelMap) {
		modelMap.addAttribute("groups", contactService.findAllGroups(CurrentUserHolder.get().getUsername()));
		return "#list-groups";
	}

	@RequestMapping(value = "/add-group", method = {RequestMethod.GET})
	public String addGroup(ModelMap modelMap) {
		modelMap.addAttribute("addGroupForm", new AddGroupForm("新建组"));
		return "#add-group";
	}
	
	@RequestMapping(value = "/add-group", method = {RequestMethod.POST})
	public String addGroup(@Valid @ModelAttribute("addGroupForm") AddGroupForm form, BindingResult bindingResult, ModelMap modelMap) {
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("hasErrors", true);
			return "#add-group";
		}
		
		Group group = form.toGroup();
		group.setOwner(CurrentUserHolder.get());
		contactService.saveGroup(group);
		return "redirect:/contact/list-groups";
	}
	
	@RequestMapping(value = "/delete-group/{groupId}", method = {RequestMethod.GET})
	public String deleteGroup(@PathVariable("groupId") Integer groupId) {
		
		if (! contactService.isGroupOwner(groupId, CurrentUserHolder.get().getUsername())) {
			throw new AccessDeniedException("");
		}
		
		if (! contactService.isGroupEmpty(CurrentUserHolder.get().getUsername(), groupId)) {
			throw new NonEmptyGroupException();
		}
		
		contactService.deleteGroup(groupId);
		return "redirect:/contact/list-groups";
	}
	
	@RequestMapping(value = "/list-contacts/{pageNumber}", method = {RequestMethod.GET})
	public String listContacts(@PathVariable("pageNumber") int pageNumber, ModelMap modelMap) {
		
		Page<Contact> page = contactService.findContacts(CurrentUserHolder.get().getUsername(), SimplePageableImpl.getInstance(pageNumber));
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("pageNumber", pageNumber);

		return "#list-contacts";
	}

	@RequestMapping(value = "/delete-contact/{contactId}/current-page/{currentPage}", method = {RequestMethod.GET})
	public String deleteContact(
			@PathVariable("contactId") int contactId,
			@PathVariable("currentPage") int currentPage) {
		
		boolean isContactOwner = contactService.isContactOwner(contactId, CurrentUserHolder.get().getUsername());
		
		if (! isContactOwner) {
			throw new AccessDeniedException("");
		}
		
		contactService.deleteContact(contactId);

		return "redirect:/contact/list-contacts/" + currentPage;
	}
	
	@RequestMapping(value = "/add-contact", method = {RequestMethod.GET})
	public String addContact(ModelMap modelMap) {
		AddContactForm form = new AddContactForm();
		form.setGender("MALE");
		modelMap.addAttribute("addContactForm", form);
		modelMap.addAttribute("groupOptions", contactService.findAllGroups(CurrentUserHolder.get().getUsername()));
		
		return "#add-contact";
	}
	
	@RequestMapping(value = "/add-contact", method = {RequestMethod.POST})
	public String addContact(
			@ModelAttribute("addContactForm") @Valid AddContactForm form, 
			BindingResult bindingResult, 
			ModelMap modelMap) {
		modelMap.addAttribute("groupOptions", contactService.findAllGroups(CurrentUserHolder.get().getUsername()));
		
		Group group = null;
		if (form.getGroupId() >= 1) {
			group = contactService.findGroupById(form.getGroupId());
			if (group.getOwner().getId() != CurrentUserHolder.getId()) {
				throw new AccessDeniedException("");
			}
		}
		
		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("hasErrors", true);
			return "#add-contact";
		}
		Contact contact = form.toContact();
		contact.setGroup(group);
		contact.setOwner(CurrentUserHolder.get());
		contactService.saveContact(contact);

		return "redirect:/contact/list-contacts/1";
	}
}
