package com.LearnSphere.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.LearnSphere.entity.Comments;
import com.LearnSphere.entity.Course;
import com.LearnSphere.entity.Lesson;
import com.LearnSphere.services.CommentService;
import com.LearnSphere.services.StudentService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Controller
public class StudentController 
{
	@Autowired
	StudentService sService;
	
	@Autowired
	CommentService comService;
	
	@GetMapping("/buyCourses")
	public String buyCourse(Model model)
	{
		List<Course> courselst=sService.getAllCourse();
		model.addAttribute("list",courselst);
		return "purchase";
	}
	
	@GetMapping("/showMyCourses")
	public String getCourse(Model model)
	{
		List<Course> courseList=sService.getAllCourse();
		Map<Course, List<Lesson>> courseLessonMap = new LinkedHashMap<>();
 		
		for (Course course : courseList) {
	        List<Lesson> lessons = sService.getLessonCourse(course);
	        courseLessonMap.put(course, lessons);
	    }

	    model.addAttribute("courseLessonMap", courseLessonMap);
	    return "myCourses";
	}


	@PostMapping("/getLesson")
	public String getLesson(@RequestParam("lessonId") int lessonId,Model model)
	{
		Lesson lesson=sService.getLesson(lessonId);
		model.addAttribute("lesson", lesson);
		
		List<Comments> comment=comService.commentList();
		model.addAttribute("list", comment);
		return "myLesson";
	}
	
	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder(@RequestParam("CoursePrice") int amount)
	{
		Order order = null;
		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_4mYkj9F3mXrOL0", "x8a01EBTaTuVeCchYPdx2XHs");
			
			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount",amount*100); // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
			orderRequest.put("currency","INR");
			orderRequest.put("receipt", "receipt#1");
			JSONObject notes = new JSONObject();
			notes.put("notes_key_1","Tea, Earl Grey, Hot");
			orderRequest.put("notes",notes);
			order = razorpay.orders.create(orderRequest);
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			return order.toString();
		}
	}

	
	
}
