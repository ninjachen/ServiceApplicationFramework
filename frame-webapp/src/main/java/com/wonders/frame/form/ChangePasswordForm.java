package com.wonders.frame.form;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

public class ChangePasswordForm implements Serializable {

	private static final long serialVersionUID = 6294850671431434818L;

	@Length(min = 5, max = 16, message = "{jsr303.changepassword.oldpwd.length}")
	private String oldPassword;
	
	@Length(min = 5, max = 16, message = "{jsr303.changepassword.newpwd1.length}")
	private String password1;

//	@Length(min = 5, max = 16, message = "{jsr303.changepassword.newpwd2.length}")
	private String password2;
	
	public ChangePasswordForm() {
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	
}
