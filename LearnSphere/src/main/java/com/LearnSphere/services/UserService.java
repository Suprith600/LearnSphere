package com.LearnSphere.services;

import com.LearnSphere.entity.Users;

public interface UserService
{

	String addUser(Users u);//adds new user to the database
	boolean checkEmail(String email); //checks email is already present in database
	boolean Validate(String webemail,String webpassword); //validate user's credentials
	String checkRole(String webemail); //check for the login user's Role
	
	
}
