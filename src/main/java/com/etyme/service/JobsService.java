package com.etyme.service;

import java.util.List;

import com.etyme.model.Jobs;
import com.etyme.model.User;

public interface JobsService {

	public List<Jobs> listJobs();	
	public void saveJob(Jobs job);
	public Jobs getJobById(int jobid);

}
