package com.etyme.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.etyme.dao.UserDao;
import com.etyme.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<User> listUsers() {
		return (List<User>) sessionFactory.getCurrentSession().createCriteria(
				User.class).list();

	}

	@Override
	public void saveUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);

	}

	@Override
	public List<User> getUserByUserEmail(String userEmail) {
		return sessionFactory.getCurrentSession().createQuery(
				"from User where email=:userEmail").setString("userEmail",
				userEmail).list();
	}

	@Override
	public List<User> validateLoginUser(String userEmail, String password) {
		return sessionFactory.getCurrentSession().createQuery(
				"from User where email=:userEmail and password=:password")
				.setString("userEmail", userEmail).setString("password",
						password).list();
	}	
}
