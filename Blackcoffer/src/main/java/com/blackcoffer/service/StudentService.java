package com.blackcoffer.service;

import java.util.List;

import com.blackcoffer.exceptions.CourseException;
import com.blackcoffer.exceptions.StudentException;
import com.blackcoffer.model.Course;
import com.blackcoffer.model.Student;

public interface StudentService {
	
	public Student registerStudent(Student student);
	
	public Student updateStudent(Student student) throws StudentException;
	
    public List<Student> getStudent() throws StudentException;
	
	public Course enrollStudentToCourse(Student student, Course course) throws StudentException; 
	
	public Student deleteStudent(Integer roll) throws CourseException, StudentException;

	
}
