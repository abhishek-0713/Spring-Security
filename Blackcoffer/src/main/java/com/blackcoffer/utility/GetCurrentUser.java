package com.blackcoffer.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.blackcoffer.model.User;
import com.blackcoffer.repository.UserRepo;

@Component
public class GetCurrentUser {

	
	@Autowired
	private UserRepo userRepo;
	
	
	/*---------------------------------------   Current User Details - Authentication -------------------------------------------*/	

	public User getLoggedInUserDetails() {	
		
		SecurityContext sc =SecurityContextHolder.getContext();
		
		Authentication auth=sc.getAuthentication();
		
		return userRepo.findByUserName(auth.getName());
	}
}
