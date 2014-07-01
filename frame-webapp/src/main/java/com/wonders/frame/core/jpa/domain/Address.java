package com.wonders.frame.core.jpa.domain;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author mengjie
 *
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class Address implements Serializable {

	private static final long serialVersionUID = 1412614837675874249L;

	private String location;
	private String zipCode;
	
	public Address() {
	}

	@Column(name = "_loc")
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "_zip")
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
