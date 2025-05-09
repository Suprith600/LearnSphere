package com.LearnSphere.services;

import java.util.List;

import com.LearnSphere.entity.Course;
import com.LearnSphere.entity.Lesson;

public interface TrainerService 
{
	public String addCourse(Course course);// for Adding new Course
	public String addLesson(Lesson lesson); //for Adding lesson to the Course
	public Course getCourse(Integer courseId); //to get the Course object
	public List<Course> getAllCourse();
	public List<Lesson> getLessonCourse(Course course);
	public Lesson getLesson(int LessonId);


}
