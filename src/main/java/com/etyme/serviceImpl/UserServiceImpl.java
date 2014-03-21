package com.etyme.serviceImpl;

import java.util.List;

import com.etyme.dao.UserDao;
import com.etyme.model.User;
import com.etyme.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<User> listUsers() {
		return userDao.listUsers();		
	}
	
	@Override
	public void saveUser(User user){
	 	 userDao.saveUser(user);
	  }
	
	@Override
	public List<User> getUserByUserEmail(String userEmail){
		   return userDao.getUserByUserEmail(userEmail);
	  }
	
	@Override
	public List<User> validateLoginUser(String userEmail,String password){
		   return userDao.validateLoginUser(userEmail, password);
		
		
	}	
}
