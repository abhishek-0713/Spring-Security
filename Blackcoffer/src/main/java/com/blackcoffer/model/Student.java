package com.blackcoffer.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer roll;
	private String name;
	private String email;
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Course> courseLists;

	public Student(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Student(Integer roll, String name, String email, String password) {
		super();
		this.roll = roll;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	
	
}
