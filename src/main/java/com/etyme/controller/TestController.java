package com.etyme.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.etyme.model.JobTypes;
import com.etyme.model.Jobs;

@Controller
@RequestMapping(value = "user/test")
public class TestController {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@RequestMapping( method = RequestMethod.GET)
	public void test() {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		transaction = session.beginTransaction();
		
		JobTypes jobType = new JobTypes();
		jobType.setType("Hire");

		Jobs job = new Jobs();
		job.setTitle("sap portal devloper");
		job.setJobtype(jobType);
		System.out.println("saved");
		
		session.save(job);
		transaction.commit();
	}	
}
