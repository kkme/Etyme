package com.etyme.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.etyme.dao.JobsDao;
import com.etyme.dao.UserDao;
import com.etyme.model.Jobs;

@Repository("jobsDao")
public class JobsDaoImpl implements JobsDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Jobs> listJobs() {
		return (List<Jobs>)sessionFactory.getCurrentSession().createQuery("from Jobs").list();
	}

	@Override
	public void saveJob(Jobs job) {
		sessionFactory.getCurrentSession().saveOrUpdate(job);
	}

	@Override
	public Jobs getJobById(int jobid) {
		return (Jobs)sessionFactory.getCurrentSession().createQuery(
				"from Jobs where id=:id").setInteger("id",
				jobid).list().get(0);
	}

}
