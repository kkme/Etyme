package com.etyme.validators;

import java.util.regex.*;
import java.util.*;

import com.etyme.utils.Encryption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.etyme.model.User;
import com.etyme.service.UserService;

@Component("userLoginValidator")
public class UserLoginValidator {
	@Autowired
	private UserService userService;
	
	public boolean supports(Class<?> klass) {
		return User.class.isAssignableFrom(klass);
	  }
	
	public void validate(Object target, Errors errors){
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userEmail","NotEmpty.user.userEmail","Email cannot not be Empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword","NotEmpty.user.userPassword","Password cannot not be Empty.");
		// check userEmail errors.....Start..............................
		if((user.getUserEmail()).length()>0){
			List usersList = userService.validateLoginUser(user.getUserEmail(), Encryption.encrypt(user.getUserPassword()));
			if(usersList != null && usersList.size() == 0 ){
			  errors.rejectValue("userEmail", "userEmail.is.not.valid", "User name and password is incorrect. Please try again.");
			 } else{
			 }
	      }
	}
 }
