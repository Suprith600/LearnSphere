package com.LearnSphere.services;

import java.util.List;

import com.LearnSphere.entity.Comments;

public interface CommentService 
{
	public List<Comments> commentList();
	public String addComment(Comments comment);

}
