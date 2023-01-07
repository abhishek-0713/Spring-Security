package com.blackcoffer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffer.exceptions.CourseException;
import com.blackcoffer.exceptions.StudentException;
import com.blackcoffer.model.Course;
import com.blackcoffer.model.Student;
import com.blackcoffer.repository.CourseRepo;
import com.blackcoffer.repository.StudentRepo;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	
	/*---------------------------------------   Add COurse  -------------------------------------------*/

	@Override
	public Course createCourse(Course course) {
		
		return courseRepo.save(course);
		
	}

	
	/*---------------------------------------   Update COurse -------------------------------------------*/

	@Override
	public Course updateCourse(Course course) {
		
		course.getStudentsList().forEach(eachStudent -> eachStudent.getCourseLists().add(course));
		
		return courseRepo.save(course);
		
	}
	
	
	/*---------------------------------------   View All COurses -------------------------------------------*/

	@Override
	public List<Course> getCourse() throws CourseException {

		List<Course> course = courseRepo.findAll();
		
        return course;
		
	}

	
	/*---------------------------------------   Allocate Student to Course -------------------------------------------*/

	@Override
	public Boolean addStudentToTheCourse(Course course, Student student) throws StudentException {
		
		Optional<Student> databaseStudent = studentRepo.findById(student.getRoll());
		
		if(databaseStudent.isPresent()) {
			
			course.getStudentsList().add(student);
			
			course.getStudentsList().forEach(eachStudent -> eachStudent.getCourseLists().add(course));
			
			courseRepo.save(course);
			
			return true;
			
			
			
		}else {
			
			throw new StudentException("No student found with this roll number");
		}
	}

	
	/*---------------------------------------   Delete Course  -------------------------------------------*/

	@Override
	public Course deleteCourse(Integer course_id) throws CourseException {
		
		Optional<Course> optional = courseRepo.findById(course_id);
		if(optional.isPresent()) {
			
			courseRepo.delete(optional.get());
			Course course = optional.get();

			return course;

		}
		throw new CourseException("No Course exist");
	
	}


}


