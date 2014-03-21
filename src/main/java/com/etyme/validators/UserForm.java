package com.etyme.validators;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserForm {

	
	private Long userId;
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	@Email
	private String userEmail;

	@NotEmpty
	@Size(min=6,max=20)	
	private String userPassword;

	@NotEmpty
	@Size(min=6,max=20)	
	private String userConfirmPassword;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserConfirmPassword() {
		return userConfirmPassword;
	}

	public void setUserConfirmPassword(String userConfirmPassword) {
		this.userConfirmPassword = userConfirmPassword;
	}

	
}
