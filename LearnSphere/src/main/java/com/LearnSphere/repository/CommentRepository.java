package com.LearnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LearnSphere.entity.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer> {

}
