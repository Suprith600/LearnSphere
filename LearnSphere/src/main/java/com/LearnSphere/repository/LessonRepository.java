package com.LearnSphere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LearnSphere.entity.Course;
import com.LearnSphere.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> 
{
	List<Lesson> findByCourse(Course course);

}
