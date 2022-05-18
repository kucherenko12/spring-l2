package com.example.demo.logIn.service;

import org.springframework.stereotype.Service;

import com.example.demo.logIn.repository.UserDAO;


@Service
public class LogInImpl implements LogIn
{
	public static final Boolean isLoggedIn = null;
	public User currentUser = new User();
	public UserDAO userDAO;
	
	
	public LogInImpl(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}
	 
	
	@Override
	public User tryLogIn(String name, String password)
	{
		if(userDAO.getUser(name, password) != null)
		{
			currentUser = userDAO.getUser(name, password);
		}

		return(currentUser);
	}

	@Override
	public User getCurrentUser() {
		// TODO Auto-generated method stub
		return currentUser;
	}

	@Override
	public String getCurrentUserUsername()
	{
		return(currentUser.getName());
	};
	
	
}
