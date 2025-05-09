package com.LearnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LearnSphere.entity.Course;
import com.LearnSphere.entity.Lesson;
import com.LearnSphere.repository.CourseRepository;
import com.LearnSphere.repository.LessonRepository;

@Service
public class StudentServiceImplementation implements StudentService
{
	@Autowired
	CourseRepository cRepo;
	@Autowired
	LessonRepository lRepo;

	@Override
	public List<Course> getAllCourse() 
	{
		return cRepo.findAll();
	}

	@Override
	public List<Lesson> getLessonCourse(Course course)
	{
		return lRepo.findByCourse(course);
	}
	
	@Override
	public Lesson getLesson(int LessonId) 
	{
		return lRepo.getById(LessonId);
	}

	

}
