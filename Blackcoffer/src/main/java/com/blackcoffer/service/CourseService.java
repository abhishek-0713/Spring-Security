package com.blackcoffer.service;

import java.util.List;

import com.blackcoffer.exceptions.CourseException;
import com.blackcoffer.exceptions.StudentException;
import com.blackcoffer.model.Course;
import com.blackcoffer.model.Student;

public interface CourseService {
	
	public Course createCourse(Course course);
	
    public List<Course> getCourse() throws CourseException;
	
	public Course updateCourse(Course course) throws CourseException;
	
	public Boolean addStudentToTheCourse(Course course, Student student) throws StudentException, CourseException;
	
	public Course deleteCourse(Integer course_id) throws CourseException;
}
