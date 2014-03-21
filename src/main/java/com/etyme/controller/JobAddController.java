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

import com.etyme.service.JobsService;
import com.etyme.service.UserService;
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

import com.etyme.model.JobStatus;
import com.etyme.model.JobTypes;
import com.etyme.model.Jobs;
import com.etyme.model.Skills;
import com.etyme.model.State;
import com.etyme.model.User;
import com.etyme.validators.JobsValidator;
import com.etyme.validators.UserForm;
import com.etyme.validators.UserSignUpValidator;

@Controller
@RequestMapping
public class JobAddController {

	@Autowired
	JobsService jobsService;
	
	@Autowired
	JobTypesServiceImpl jobTypesService;

	@Autowired
	UserService userService;
	
	@Autowired
	SkillsServiceImpl skillSetTypesService;
	
	@Autowired
	JobsValidator jobsValidator;
	
	@Autowired
	StateServiceImpl stateService;
	
	@RequestMapping(value="user/jobAdd", method = RequestMethod.GET)
	public ModelAndView getLogin(@Param int jobId, Map model, HttpSession session) {

		Jobs job;
		if (jobId == 0) {
			job = new Jobs();
		} else {
			job = jobsService.getJobById(jobId);
		}
		model.put("job", job);

		List types = jobTypesService.listTypes();
		model.put("jobTypes", types);

		int[] opn = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		model.put("openings", opn);

		List<User> recruiters = userService.listUsers();
		model.put("recruiter", recruiters);
		
		List<Skills> skills = skillSetTypesService.listTypes();		
		model.put("skillsList", skills);
		model.put("selectedSkills", ListUtil.markSelectedSkills(skills,
				(job.getSkills() !=null)?job.getSkills(): new ArrayList()));

		List statuses = JobStatus.getAllStatus();
		model.put("jobStatuses", statuses);
		
		return new ModelAndView("user/jobAdd");
	
}
	
	@RequestMapping(value="user/jobAdd" , method = RequestMethod.POST)
	public ModelAndView saveJob(@Valid Jobs job,
	BindingResult result, Map model) {
	//	userSignUpValidator.validate(userForm, result);
	//	if (result.hasErrors()) {
	//		return new ModelAndView("user/userSignUp");
	//	} else {
/*		Set skillSelected = new HashSet<>();
		Set<String> jobSkills = new HashSet<>();
		if (job.getSkills() != null ) 
			jobSkills = job.getSkills();
		for (String s: jobSkills){
			Skills skill = new Skills();
			skill = skillSetTypesService.getSkill(Integer.parseInt(s));
			skillSelected.add(skill);
		}
			job.setSkills(skillSelected); 
*/			
			if (result.hasErrors()) {
				System.out.println("error" + result.getErrorCount());
			}
			jobsService.saveJob(job);
	//	}
		return new ModelAndView("redirect:jobs");
	}
	
	@RequestMapping(value="user/get_states", method = RequestMethod.GET)
	public @ResponseBody List getStates(@RequestParam("q") String query) { 
		List stateList = stateService.findCityStateAutoComplete(query);
		return stateList;
	}

	@RequestMapping(value="user/get_statesById", method = RequestMethod.GET)
	public @ResponseBody Object getStatesById(@RequestParam("id") String id) { 
		List stateList = stateService.findCityStateById(Integer.parseInt(id));
		return stateList.get(0);
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
