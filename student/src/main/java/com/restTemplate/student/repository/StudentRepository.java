package com.restTemplate.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restTemplate.student.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, String> {

}
