package com.etyme.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.etyme.service.UserService;
import com.etyme.utils.Encryption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.etyme.model.User;
import com.etyme.validators.UserForm;
import com.etyme.validators.UserSignUpValidator;

@Controller
@RequestMapping("user/userSignUp")
public class UserSignUpController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserSignUpValidator userSignUpValidator;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLogin(Map model, HttpSession session) {

		UserForm userForm = new UserForm();
		model.put("userForm", userForm);
		return new ModelAndView("user/userSignUp");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveSignUp(@Valid UserForm userForm,
	BindingResult result, Map model) {
		userSignUpValidator.validate(userForm, result);
		if (result.hasErrors()) {
			return new ModelAndView("user/userSignUp");
		} else {
			User user = new User();
			user.setUserName(userForm.getUserName());
			user.setUserPassword(Encryption.encrypt(userForm.getUserPassword()));
			user.setUserEmail(userForm.getUserEmail());
			
			userService.saveUser(user);
		}
		return new ModelAndView("redirect:userLogin");
	}
	
}
