package com.example.demo.logIn.repository;

import java.sql.SQLException;

import com.example.demo.logIn.service.User;

public interface UserDAO
{
	public User getUser(String name, String password);


}
