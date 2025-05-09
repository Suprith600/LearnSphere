package com.LearnSphere.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LearnSphere.entity.Course;
import com.LearnSphere.entity.Lesson;
import com.LearnSphere.services.CommentService;
import com.LearnSphere.services.TrainerService;

@Controller
public class TrainerController 
{
	@Autowired
	TrainerService tService;
	
	@Autowired
	CommentService comService;
	
	@PostMapping("/addCourse")
	public String addCourse(@RequestParam("cid") int courseId,
							@RequestParam("cname") String courseName,
							@RequestParam("cprice") int coursePrice)
	{
		Course c=new Course();
		c.setCourseId(courseId);
		c.setCourseName(courseName);
		c.setCoursePrice(coursePrice);
		
		tService.addCourse(c);
		return "trainerHome";
	}
	
	@PostMapping("/addLesson")
	public String addLesson(@RequestParam("lid") int lessonId,
							@RequestParam("lname") String lessonName,
							@RequestParam("ltopics") String lessonTopics,
							@RequestParam("vlink") String videoLink,
							@RequestParam("cid") int courseid)
	{
		Course course=tService.getCourse(courseid);
		Lesson lesson=new Lesson(lessonId,lessonName,lessonTopics,videoLink,course);
		tService.addLesson(lesson);
		
		course.getLessons().add(lesson);
		tService.addCourse(course);
		return "trainerHome";		
	}
	
	@GetMapping("/showCourses")
	public String getCourse(Model model)
	{
		List<Course> courseList=tService.getAllCourse();
		Map<Course, List<Lesson>> courseLessonMap = new LinkedHashMap<>();
 		
		for (Course course : courseList) {
	        List<Lesson> lessons = tService.getLessonCourse(course);
	        courseLessonMap.put(course, lessons);
	    }

	    model.addAttribute("courseLessonMap", courseLessonMap);
	    return "viewCourses";
	}
	

}
