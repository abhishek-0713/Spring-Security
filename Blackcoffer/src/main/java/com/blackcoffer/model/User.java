package com.blackcoffer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String address;
	private String password;
	private String role;
	
	public User(String userName, String address, String password, String role) {
		super();
		this.userName = userName;
		this.address = address;
		this.password = password;
		this.role = role;
	}
	
}
