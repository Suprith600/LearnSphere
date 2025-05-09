package com.LearnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.LearnSphere.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>
{
	boolean existsByEmail(String email);
	Users findByEmail(String email);

}
