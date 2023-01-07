package com.blackcoffer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blackcoffer.model.User;
import com.blackcoffer.repository.UserRepo;

@Service
public class MyUserDetailService  implements UserDetailsService{

	
	@Autowired
	private UserRepo userRepo;
	@Override
	
	
	/*---------------------------------------   FInd User By UserName -------------------------------------------*/	

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByUserName(username);
		
		if(user != null) {
			
			return new MyUserDetails(user);
		}
		else {
			throw new UsernameNotFoundException("No User Found");
		}
		
	}

}
