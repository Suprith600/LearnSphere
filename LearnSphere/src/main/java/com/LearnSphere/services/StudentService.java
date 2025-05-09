package com.LearnSphere.services;

import java.util.List;

import com.LearnSphere.entity.Course;
import com.LearnSphere.entity.Lesson;

public interface StudentService 
{
	public List<Course> getAllCourse();
	public Lesson getLesson(int LessonId);
	public List<Lesson> getLessonCourse(Course course);

}
