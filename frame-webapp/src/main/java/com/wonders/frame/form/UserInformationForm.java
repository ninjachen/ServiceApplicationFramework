package com.wonders.frame.form;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.wonders.frame.core.jpa.domain.Name;
import com.wonders.frame.core.jpa.domain.User;

public class UserInformationForm implements Serializable {

	private static final long serialVersionUID = -5787971370581035321L;

	private String lastName;
	private String firstName;
	private List<String> emails;
	
	private String gender;
	private List<String> genderOptions;

	public UserInformationForm() {
		super();
		genderOptions = Arrays.asList("男", "女");
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public List<String> getGenderOptions() {
		return genderOptions;
	}

	public void setGenderOptions(List<String> genderOptions) {
		this.genderOptions = genderOptions;
	}

	public User toUser() {
		User user = new User();
		user.setName(new Name());
		user.getName().setFirstName(this.firstName);
		user.getName().setLastName(this.lastName);
		user.setEmails(this.emails);
		user.setGender(this.gender.equals("男") ? User.Gender.MALE : User.Gender.FEMALE);
		return user;
	}
}
