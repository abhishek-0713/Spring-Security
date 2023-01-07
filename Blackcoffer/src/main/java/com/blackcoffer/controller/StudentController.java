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
import com.blackcoffer.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	/*---------------------------------------   Register Student Mapping -------------------------------------------*/
	
	@PostMapping("/register")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student) throws StudentException {
		
		if(student != null) {
		
			Student databaseStudent = studentService.registerStudent(student);
			
			return new ResponseEntity<Student>(databaseStudent,HttpStatus.ACCEPTED);
			
		}
		else {
			
			throw new StudentException("Please enter valid details");
		}
		
	}
	
	
	/*---------------------------------------   Update Student Details  Mapping -------------------------------------------*/

	@PostMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws StudentException{
		
		if(student != null) {
			
			Student updatedStudent = studentService.updateStudent(student);
			
			return new ResponseEntity<Student>(updatedStudent,HttpStatus.ACCEPTED);
			
		}
		else {
			
			throw new StudentException("Please enter valid details");
		}
	}
	
	
	/*---------------------------------------   View All Students Mapping -------------------------------------------*/
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllBankAccountMapping() throws StudentException{
		
		return new ResponseEntity<List<Student>>(studentService.getStudent(), HttpStatus.FOUND);
		
	}
	
	
	/*---------------------------------------   Allocate Student to Course Mapping -------------------------------------------*/

	@PostMapping("/enrollcourse")
	public ResponseEntity<Course> enrollcourse(@RequestBody Student student, @RequestBody Course course) throws StudentException{
		
		if(student != null || course != null) {
			
			Course allotedCourse = studentService.enrollStudentToCourse(student, course);
			
			return new ResponseEntity<Course>(allotedCourse,HttpStatus.ACCEPTED);
			
		}
		else {
			
			throw new StudentException("Please enter valid details");
		}
	}
	
	
	/*---------------------------------------   Delete  Students Mapping -------------------------------------------*/
	@DeleteMapping("/delete")
	public ResponseEntity<Student> removeAccountMapping(@RequestParam("roll") Integer roll) throws StudentException, CourseException{

		return new ResponseEntity<>(studentService.deleteStudent(roll),HttpStatus.OK);
	}

	
}

