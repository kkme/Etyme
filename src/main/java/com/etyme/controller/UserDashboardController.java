package com.etyme.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.etyme.model.User;
import com.etyme.service.UserService;
import com.etyme.validators.UserLoginValidator;

@Controller
@RequestMapping("user/userDashboard")
public class UserDashboardController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLogin(Map model, HttpSession session) {

		//check if the user is logged in.
		if (session.getAttribute("user") == null) {
			User user = new User();
			model.put("user", user);
			return new ModelAndView("user/userLogin");			
		}
		User user = (User)session.getAttribute("user");
		model.put("userName", user.getUserName());
		return new ModelAndView("user/userDashboard");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loginUser(@Valid User user,
			BindingResult result, Map model, HttpSession session) {
		return null;
	}
	
}
