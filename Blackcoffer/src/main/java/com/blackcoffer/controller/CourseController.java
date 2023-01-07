package com.blackcoffer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blackcoffer.exceptions.CourseException;
import com.blackcoffer.exceptions.StudentException;
import com.blackcoffer.model.Course;
import com.blackcoffer.model.Student;
import com.blackcoffer.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	/*---------------------------------------   Add COurse  -------------------------------------------*/

	@PostMapping("/create")
	public ResponseEntity<Course> registerCourse(@RequestBody Course course) throws CourseException {
		
		if(course != null) {
		
			Course createdCourse = courseService.createCourse(course);
			
			return new ResponseEntity<Course>(createdCourse,HttpStatus.ACCEPTED);
			
		}else {
			
			throw new CourseException("Please enter valid details");
		}
		
		
		
	}
	
	
	/*---------------------------------------   Update COurse -------------------------------------------*/

	@PostMapping("/update")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course) throws CourseException {
		
		if(course != null) {
		
			Course updatedCourse = courseService.updateCourse(course);
			
			return new ResponseEntity<Course>(updatedCourse,HttpStatus.ACCEPTED);
			
		}else {
			
			throw new CourseException("Please enter valid details");
		}
		
		
		
	}
	

	
	/*---------------------------------------   View All COurses -------------------------------------------*/
	@GetMapping("/all")
	public ResponseEntity<List<Course>> getAllBankAccountMapping() throws CourseException{
		
		return new ResponseEntity<List<Course>>(courseService.getCourse(),HttpStatus.FOUND);
		
	}
	
	
	
	/*---------------------------------------   Allocate Student to Course -------------------------------------------*/

	@PostMapping("/addstudent")
	public ResponseEntity<Boolean> addStudentToTheCourse(@RequestBody Course course, @RequestBody Student student) throws CourseException, StudentException {
		
		if(course != null || student != null) {
		
			Boolean result = courseService.addStudentToTheCourse(course, student);
			
			return new ResponseEntity<Boolean>(result,HttpStatus.ACCEPTED);
			
		}else {
			
			throw new CourseException("Please enter valid details");
		}	
		
	}
	
	
	/*---------------------------------------   Delete  Course -------------------------------------------*/
	@DeleteMapping("/delete")
	public ResponseEntity<Course> removeAccountMapping(@RequestParam Integer course_id) throws CourseException{

		return new ResponseEntity<>(courseService.deleteCourse(course_id),HttpStatus.OK);
	}



}

