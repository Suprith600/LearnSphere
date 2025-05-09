package com.LearnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LearnSphere.entity.Comments;
import com.LearnSphere.entity.Users;
import com.LearnSphere.services.CommentService;
import com.LearnSphere.services.UserService;

@Controller
public class ServiceController 
{
	@Autowired
	UserService us;
	
	@Autowired
	CommentService comService;
	
	@PostMapping("/registerUser")
	public String addUser(@RequestParam("name") String Name,
						  @RequestParam("mail") String Email,
						  @RequestParam("pass") String Password,
						  @RequestParam("role") String Role,
						  @RequestParam("mobile") String Mobile)
	{
		boolean emailExists=us.checkEmail(Email);
		if(emailExists==false)
		{
			Users user=new Users();
			user.setName(Name);
			user.setEmail(Email);
			user.setPassword(Password);
			user.setRole(Role);
			user.setMobile(Mobile);
			
			us.addUser(user);
			System.out.println("user registered successfully!");
			return "login";
		}
		else
		{
			System.out.println("User already exists");
			return "register";
		}

	}

	@PostMapping("/loginUser")
	public String validateUser(@RequestParam("mail") String webemail,
							   @RequestParam("pass") String webpassword)
	{
		if(us.checkEmail(webemail)==true)// email already exist
		{
			boolean v=us.Validate(webemail, webpassword);
			//if user is valid
			if(v==true)
			{
				if(us.checkRole(webemail).equals("trainer"))
					return "trainerHome";
				else
					return "studentHome";
			}
			else
			{
				System.out.println("incorrect credentials, try again");
				return "login";
			}
		}
		else
		{
			System.out.println("Email doesnt exist");
			return "register";
		}
	}
	
	@PostMapping("/addComment")
	public String addComment(@RequestParam("comment")String comment,Model model)
	{
		Comments com=new Comments();
		com.setComment(comment);
		comService.addComment(com);
		
		List<Comments> commentslist=comService.commentList();
		model.addAttribute("list", commentslist);
		
		return "redirect:/showMyCourses";
	}

}
