package com.wonders.frame.form;

import java.io.Serializable;

import com.wonders.frame.core.jpa.domain.Group;

import org.hibernate.validator.constraints.Length;

public class AddGroupForm implements Serializable {

	private static final long serialVersionUID = 6730794490549350494L;

	@Length(min=1, max=20, message="{jsr303.addgroup.name}")
	private String name;
	private String description;
	
	public AddGroupForm() {
	}
	
	public AddGroupForm(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Group toGroup() {
		Group g = new Group();
		g.setName(getName());
		g.setDescription(getDescription());
		return g;
	}
}
