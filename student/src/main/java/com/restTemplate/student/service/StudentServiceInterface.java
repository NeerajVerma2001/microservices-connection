package com.restTemplate.student.service;

import java.util.List;

import com.restTemplate.student.model.StudentModel;

import jakarta.servlet.http.HttpServletRequest;

public interface StudentServiceInterface {

	public List<StudentModel> createStudentInfo(List<StudentModel> model, HttpServletRequest request);

	public List<StudentModel> getAllStudent();

	public StudentModel getStudentById(String id);
}
