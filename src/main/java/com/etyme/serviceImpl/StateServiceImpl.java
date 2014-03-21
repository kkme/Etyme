package com.etyme.serviceImpl;

import java.util.List;

import com.etyme.dao.UserDao;
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

@Service("stateService")
@Transactional
public class StateServiceImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<State> listStates() {
		return (List<State>)sessionFactory.getCurrentSession().createCriteria(State.class).list();
	}

	public List<State> findState(String term) {
		return (List<State>)sessionFactory.getCurrentSession()
				.createCriteria(State.class)
				.add(Restrictions.like("state", "%" + term + "%"))
				.list();
	}

	public List findCityStateAutoComplete(String term) {
		return (List)sessionFactory.getCurrentSession()
				.createQuery("select c.id as id, s.state as state, c.city as city from State as s inner join s.City as c"
						+ " where s.state like :state OR c.city like :city")
				.setParameter("state", "%" + term + "%")
				.setParameter("city", "%" + term + "%")
				.list();
	}
	public List findCityStateById(int id) {
		return (List)sessionFactory.getCurrentSession()
				.createQuery("select c.id as id, s.state as state, c.city as city from State as s inner join s.City as c"
						+ " where c.id = :cityid")
				.setParameter("cityid", id)
				.list();
	}
}
