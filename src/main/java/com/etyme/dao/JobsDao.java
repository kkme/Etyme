package com.etyme.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.etyme.model.Jobs;
import com.etyme.model.User;

public interface JobsDao {
	
	public List<Jobs> listJobs();	
	public void saveJob(Jobs job);
	public Jobs getJobById(int jobid);
	
}
