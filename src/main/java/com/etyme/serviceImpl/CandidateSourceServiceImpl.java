package com.etyme.serviceImpl;

import java.util.List;

import com.etyme.dao.UserDao;
import com.etyme.model.CandidateSource;
import com.etyme.model.JobTypes;
import com.etyme.model.Jobs;
import com.etyme.model.State;
import com.etyme.model.City;
import com.etyme.model.User;
import com.etyme.service.UserService;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("candidateSourceService")
@Transactional
public class CandidateSourceServiceImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<CandidateSource> listTypes() {
		return (List<CandidateSource>)sessionFactory.getCurrentSession().createCriteria(CandidateSource.class).list();
	}

}
