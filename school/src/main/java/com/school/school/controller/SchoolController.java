package com.school.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.school.model.SchoolModel;
import com.school.school.serviceInterface.SchoolServiceInterface;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class SchoolController {

	@Autowired
	private SchoolServiceInterface service;

	@GetMapping("/getschool")
	public String getSchoool() {
		return "<h1> Address : Indirapuram, Ghaziabad <h1>";
	}

	@PostMapping("/createSchool")
	public ResponseEntity<SchoolModel> insertSchool(@RequestBody SchoolModel model, HttpServletRequest request) {
		return new ResponseEntity<SchoolModel>(service.insertSchool(model, request), HttpStatus.CREATED);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<SchoolModel> getById(@PathVariable Integer id, HttpServletRequest request){
		SchoolModel schoolModel = service.getById(id, request);
		if(schoolModel == null ) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(schoolModel, HttpStatus.OK);
	}
	
}
