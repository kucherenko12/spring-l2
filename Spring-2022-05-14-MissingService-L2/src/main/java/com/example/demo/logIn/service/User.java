package com.example.demo.logIn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class User
{
	private String name;
	private String password;
	private List<String> hobbies;
	private Boolean isAdmin;
	
	public User(String name, String password)
	{
		this.name = name;
		this.password = password;
		this.isAdmin = false;
		hobbies = new ArrayList<>();
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}
	
	
	
}
