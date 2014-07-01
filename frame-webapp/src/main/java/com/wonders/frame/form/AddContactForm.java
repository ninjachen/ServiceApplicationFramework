package com.wonders.frame.form;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.wonders.frame.core.jpa.domain.Contact;
import com.wonders.frame.core.jpa.domain.Name;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class AddContactForm implements Serializable {

	private static final long serialVersionUID = 4295798325688228185L;

	@NotBlank(message = "{jsr303.addcontact.lastname}")
	private String lastName;
	
	@NotBlank(message = "{jsr303.addcontact.firstname}")
	private String firstName;
	
	@NotBlank(message = "{jsr303.addcontact.gender}")
	private String gender;
	
	@Pattern(regexp = "\\d{3}-\\d{4}-\\d{4}", message = "{jsr303.addcontact.cellphone}")
	private String cellPhoneNumber;
	
	@Email(message = "{jsr303.addcontact.personalemail}")
	private String personalEmail;
	
	@Email(message = "{jsr303.addcontact.workemail}")
	private String workEmail;
	
	@NotNull(message = "{jsr303.addcontact.groupid}")
	private Integer groupId;
	
	public AddContactForm() {
		super();
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

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Contact toContact() {
		Contact c = new Contact();
		c.setName(new Name());
		c.getName().setLastName(getLastName());
		c.getName().setFirstName(getFirstName());
		c.setCellPhoneNumber(getCellPhoneNumber());
		c.setPersonalEmail(getPersonalEmail());
		c.setWorkEmail(getWorkEmail());

		return c;
	}
}
