package com.blackcoffer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackcoffer.exceptions.StudentException;
import com.blackcoffer.model.Course;
import com.blackcoffer.model.Student;
import com.blackcoffer.repository.CourseRepo;
import com.blackcoffer.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	
	/*---------------------------------------   Register Student -------------------------------------------*/

	@Override
	public Student registerStudent(Student student) {
		
		return studentRepo.save(student);
		
	}
	
	
	/*---------------------------------------   Update Student Details -------------------------------------------*/

	@Override
	public Student updateStudent(Student student) throws StudentException {
		
		Optional<Student> databaseStudent = studentRepo.findById(student.getRoll());
		
		if(databaseStudent.isPresent()) {
			
			return studentRepo.save(student);
			
			
		}else {
			
			throw new StudentException("No student found with this roll number");
		}
	}

	
	/*---------------------------------------   Allocate Student to Course -------------------------------------------*/

	@Override
	public Course enrollStudentToCourse(Student student,Course course) throws StudentException {
		
		Optional<Student> databaseStudent = studentRepo.findById(student.getRoll());
		
		if(databaseStudent.isPresent()) {
			
			student.getCourseLists().add(course);
			
			course.getStudentsList().add(student);
			
			studentRepo.save(student);
			
			return courseRepo.save(course);
			
			
		}else {
			
			throw new StudentException("No student found with this roll number");
		}
		
		
	}
	

	/*---------------------------------------   View All Students -------------------------------------------*/

	@Override
	public List<Student> getStudent() throws StudentException {

		List<Student> students = studentRepo.findAll();
		
        return students;
		
	}

	
	/*---------------------------------------   Delete Student -------------------------------------------*/

	@Override
	public Student deleteStudent(Integer roll) throws StudentException {
		
		Optional<Student> optional = studentRepo.findById(roll);
		if(optional.isPresent()) {
			
			studentRepo.delete(optional.get());
			Student student = optional.get();

			return student;

		}
		throw new StudentException("No Student exist");
		

	}
	
	

}







