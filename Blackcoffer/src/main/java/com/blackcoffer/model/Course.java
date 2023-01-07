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
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	private String courseName;
	private Integer courseFees;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Student> studentsList;
	

	public Course(String courseName, Integer courseFees) {
		super();
		this.courseName = courseName;
		this.courseFees = courseFees;
	}

	public Course(Integer courseId, String courseName, Integer courseFees) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseFees = courseFees;
	}
	
	
}
