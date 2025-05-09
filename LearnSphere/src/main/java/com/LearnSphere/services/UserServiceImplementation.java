package com.LearnSphere.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LearnSphere.entity.Users;
import com.LearnSphere.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService 
{

	@Autowired
	UserRepository repo;

	@Override
	public String addUser(Users u) {
		// TODO Auto-generated method stub
		repo.save(u);
		return "Student added Successfully";
	}
	
	@Override
	public boolean Validate(String webemail, String webpassword) 
	{
		// TODO Auto-generated method stub
		Users u=repo.findByEmail(webemail);
		if(webpassword.equals(u.getPassword()))
			return true;
		else 
			return false;
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return repo.existsByEmail(email);
	}

	@Override
	public String checkRole(String webemail) {
		// TODO Auto-generated method stub
		Users u=repo.findByEmail(webemail);
		return u.getRole();
	}
	

}
