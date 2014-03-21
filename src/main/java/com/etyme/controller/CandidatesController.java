package com.etyme.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.etyme.service.CandidatesService;
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

import com.etyme.model.Candidates;

@Controller
@RequestMapping("user/candidates")
public class CandidatesController {

	@Autowired
	CandidatesService candidateService;
		
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView get(Map model, HttpSession session) {
		
		List<Candidates> CandidatesList  = candidateService.listCandidates();
		model.put("candidatesList", CandidatesList);
		return new ModelAndView("user/candidates");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView saveSignUp(Map model, HttpSession session) {
		return get(model, session);
	}
	
}
