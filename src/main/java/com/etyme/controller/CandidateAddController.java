package com.etyme.controller;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.etyme.service.CandidatesService;
import com.etyme.service.JobsService;
import com.etyme.service.UserService;
import com.etyme.serviceImpl.CandidateSourceServiceImpl;
import com.etyme.serviceImpl.JobTypesServiceImpl;
import com.etyme.serviceImpl.SkillsServiceImpl;
import com.etyme.serviceImpl.StateServiceImpl;
import com.etyme.utils.Encryption;
import com.etyme.utils.ListUtil;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.etyme.model.Candidates;
import com.etyme.model.Skills;
import com.etyme.model.State;

@Controller
@RequestMapping
public class CandidateAddController {

	@Autowired
	CandidatesService candidateService;
	
	@Autowired
	CandidateSourceServiceImpl candidateSourceService;
	
	@Autowired
	SkillsServiceImpl skillSetTypesService;
		
	@Autowired
	StateServiceImpl stateService;
	
	@RequestMapping(value="user/candidateAdd", method = RequestMethod.GET)
	public ModelAndView getCandidate(@Param int canId, Map model, HttpSession session) {

		Candidates Candidate;
		if (canId == 0) {
			Candidate = new Candidates();
		} else {
			Candidate = candidateService.getCandidatesById(canId);
		}
		model.put("candidate", Candidate);

		List types = candidateSourceService.listTypes();
		model.put("sourceTypes", types);
		
		List<Skills> skills = skillSetTypesService.listTypes();		
		model.put("skillsList", skills);
		model.put("selectedSkills", ListUtil.markSelectedSkills(skills,
				(Candidate.getSkills() !=null)?Candidate.getSkills(): new ArrayList()));
		
		return new ModelAndView("user/candidateAdd");
	
}
	
	@RequestMapping(value="user/candidateAdd" , method = RequestMethod.POST)
	public ModelAndView saveJob(@Valid Candidates candidate,
	BindingResult result, Map model) {
	//	userSignUpValidator.validate(userForm, result);
	//	if (result.hasErrors()) {
	//		return new ModelAndView("user/userSignUp");
	//	} else {			
			if (result.hasErrors()) {
				System.out.println("error" + result.getErrorCount());
			}
			candidateService.saveCandidate(candidate);
		return new ModelAndView("redirect:candidates");
	}
	
	//http://static.springsource.org/spring/docs/3.0.x/reference/validation.html
	// http://sirinsevinc.wordpress.com/2008/07/02/customeditor-for-binding-in-spring-mvc/
	@InitBinder
	protected void initBinder(HttpServletRequest request, 
	            ServletRequestDataBinder binder) throws Exception {   
	
	  binder.registerCustomEditor(Set.class, "skills", new  
		CustomCollectionEditor(Set.class) {
		    @Override
		    protected Object convertElement(Object element) {
		      String categoryId = (String)element;
		      return skillSetTypesService.getSkill(Integer.valueOf(categoryId));
		    }			    
	  });
	}
}
