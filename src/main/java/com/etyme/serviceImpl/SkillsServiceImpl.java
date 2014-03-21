package com.etyme.serviceImpl;

import java.util.List;

import com.etyme.dao.UserDao;
import com.etyme.model.JobTypes;
import com.etyme.model.Jobs;
import com.etyme.model.Skills;
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

@Service("skillSetTypesService")
@Transactional
public class SkillsServiceImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Skills> listTypes() {
		return (List<Skills>)sessionFactory.getCurrentSession().createCriteria(Skills.class).list();
	}

	public Skills getSkill(int skillId) {
		return (Skills)sessionFactory.getCurrentSession()
				.createQuery("from Skills where id = :skillid")
				.setInteger("skillid", skillId)
				.list().get(0);
	}
}
