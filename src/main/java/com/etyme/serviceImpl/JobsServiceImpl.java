package com.etyme.serviceImpl;

import java.util.List;

import com.etyme.dao.JobsDao;
import com.etyme.dao.UserDao;
import com.etyme.model.Jobs;
import com.etyme.model.User;
import com.etyme.service.JobsService;
import com.etyme.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("jobsService")
@Transactional
public class JobsServiceImpl implements JobsService{

	@Autowired
	private JobsDao jobsDao;
	
	@Override
	public List<Jobs> listJobs() {
		// TODO Auto-generated method stub
		return jobsDao.listJobs();
	}

	@Override
	public void saveJob(Jobs job) {
		jobsDao.saveJob(job);
		
	}

	@Override
	public Jobs getJobById(int jobid) {
		// TODO Auto-generated method stub
		return jobsDao.getJobById(jobid);
	}	
}
