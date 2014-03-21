package com.etyme.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.etyme.service.JobsService;
import com.etyme.service.UserService;
import com.etyme.utils.Encryption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.etyme.model.Jobs;
import com.etyme.validators.JobsValidator;

@Controller
@RequestMapping("user/jobs")
public class JobsController {

	@Autowired
	JobsService jobsService;
	
	@Autowired
	JobsValidator jobsValidator;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get(Map model, HttpSession session) {
		
		List<Jobs> jobsList  = jobsService.listJobs();
		model.put("jobsList", jobsList);
		return new ModelAndView("user/jobs");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveSignUp(Map model, HttpSession session) {
		return get(model, session);
	}
	
}
