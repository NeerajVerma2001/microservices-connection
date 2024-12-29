package com.restTemplate.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.restTemplate.student.model.StudentModel;
import com.restTemplate.student.service.StudentServiceInterface;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceInterface service;
	@Autowired  
	private RestTemplate restTemplate;

	@PostMapping("/create/student-info")
	public ResponseEntity<List<StudentModel>> createStudentInfo(@RequestBody List<StudentModel> model, HttpServletRequest request) {
		return new ResponseEntity<>(service.createStudentInfo(model,request), HttpStatus.CREATED);
				}

	@GetMapping("/getAll/student")
	public ResponseEntity<List<StudentModel>> getAllStudent(){
		return new ResponseEntity<List<StudentModel>>(service.getAllStudent(),HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<StudentModel> getStudentById(@PathVariable String id){
		return new ResponseEntity<>(service.getStudentById(id), HttpStatus.OK);
	}
	
//	@GetMapping("/getstudent")
//	public String getStudent() {
////		String address = restTemplate.getForObject("http://localhost:8080/getschool", String.class);
////		String address = restTemplate.getForObject("http://localhost:8080/getschool", String.class);
//		String add = new RestTemplate().exchange("http://localhost:8080/getschool", String.class);
//		return "<h1> Name : Neeraj Verma , Class : 12th </h1>" + add ;
//	}

}
