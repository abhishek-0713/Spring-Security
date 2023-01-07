package com.blackcoffer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blackcoffer.model.User;
import com.blackcoffer.repository.UserRepo;

@RestController
@RequestMapping("blackcoffer/user")
public class UserController {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/home")
	public ResponseEntity<String> admin(){
		
		return new ResponseEntity<String>("Welcome to 29kreative App for Admin",HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User registerUser = userRepo.save(user);
		
		return new ResponseEntity<User>(registerUser, HttpStatus.CREATED);
	}
	
	

}
