package com.LearnSphere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.LearnSphere.services.UserService;

@Controller
public class NavController 
{
	UserService us;
	
	public NavController(UserService us) {
		super();
		this.us = us;
	}

	@GetMapping("/")
	public String indexMap()
	{
		return "index";
	}
	
	@GetMapping("/login")
	public String loginMap()
	{
		return "login";
	}
	
	@GetMapping("/register")
	public String registerMap()
	{
		return "register";
	}
	
	@GetMapping("/trainerHome")
	public String trainerHomeMap()
	{
		return "trainerHome";
	}
	
	@GetMapping("/studentHome")
	public String studentHomeMap()
	{
		return "studentHome";
	}

	@GetMapping("/addLesson")
	public String addLessonMap()
	{
		return "addLesson";
	}
	
	@GetMapping("/createCourse")
	public String createCourseMap()
	{
		return "createCourse";
	}
	
	@GetMapping("/demoLesson")
	public String demoLessonMap()
	{
		return "demoLesson";
	}

}
