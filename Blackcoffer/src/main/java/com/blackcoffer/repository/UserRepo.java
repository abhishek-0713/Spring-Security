package com.blackcoffer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blackcoffer.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	public User findByUserName(String userName);
	
}