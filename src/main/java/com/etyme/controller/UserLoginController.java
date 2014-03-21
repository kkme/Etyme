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
@RequestMapping("user/userLogin")
public class UserLoginController {

	@Autowired
	UserLoginValidator userLoginValidator;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getLogin(Map model, HttpSession session) {
		User user = new User();
		model.put("user", user);
		return new ModelAndView("user/userLogin");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loginUser(@Valid User user,
			BindingResult result, Map model, HttpSession session) {
		userLoginValidator.validate(user, result);
		if (result.hasErrors()) {
			session.setAttribute("userEmail", user.getUserEmail());
			return new ModelAndView("user/userLogin"); 
		}
		List userList = userService.getUserByUserEmail(user.getUserEmail());
		if (userList != null && userList.size() > 0) {
			User userLogged = (User)userList.get(0);
			session.setAttribute("user", userLogged);
		}
		return new ModelAndView("redirect:userDashboard");
	}
	
}
