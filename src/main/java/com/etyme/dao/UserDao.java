package com.etyme.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.etyme.model.User;

public interface UserDao {
	
	public List<User> listUsers();	
	public void saveUser(User user);
	public List<User> getUserByUserEmail(String userEmail);
	public List<User> validateLoginUser(String userEmail, String password);
	
}
