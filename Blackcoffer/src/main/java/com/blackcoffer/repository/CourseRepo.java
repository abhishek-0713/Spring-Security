package com.blackcoffer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blackcoffer.model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
