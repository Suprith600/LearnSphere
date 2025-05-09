package com.LearnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LearnSphere.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
