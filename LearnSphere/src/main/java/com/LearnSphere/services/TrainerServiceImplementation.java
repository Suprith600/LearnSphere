package com.LearnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LearnSphere.entity.Course;
import com.LearnSphere.entity.Lesson;
import com.LearnSphere.repository.CourseRepository;
import com.LearnSphere.repository.LessonRepository;

@Service
public class TrainerServiceImplementation implements TrainerService
{
	@Autowired
	CourseRepository cRepo;
	@Autowired
	LessonRepository lRepo;

	@Override
	public String addCourse(Course course) {
		cRepo.save(course);
		return "Course Added";
	}

	@Override
	public String addLesson(Lesson lesson) {
		lRepo.save(lesson);
		return "Lesson Added successfully";
	}

	@Override
	public Course getCourse(Integer courseId) {
		Course course=cRepo.findById(courseId).get();
		System.out.println(course);
		System.out.println(course.getLessons());
		return course;
 }

	@Override
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
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
