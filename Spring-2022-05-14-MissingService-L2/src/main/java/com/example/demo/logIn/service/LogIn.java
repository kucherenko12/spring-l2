package com.example.demo.logIn.service;


public interface LogIn
{
public User tryLogIn(String name, String password);

public User getCurrentUser();

public String getCurrentUserUsername();

}
