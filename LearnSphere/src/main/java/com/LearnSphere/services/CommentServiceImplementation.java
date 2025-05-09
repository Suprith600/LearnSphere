package com.LearnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LearnSphere.entity.Comments;
import com.LearnSphere.repository.CommentRepository;

@Service
public class CommentServiceImplementation implements CommentService
{
	@Autowired
	CommentRepository comRepo;

	@Override
	public List<Comments> commentList() {
		return comRepo.findAll();
	}

	@Override
	public String addComment(Comments comment) {
		comRepo.save(comment);
		return "comment added";
	}
	

}
