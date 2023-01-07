package com.blackcoffer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blackcoffer.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
