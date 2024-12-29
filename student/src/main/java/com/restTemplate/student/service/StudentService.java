package com.restTemplate.student.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.restTemplate.student.model.StudentModel;
import com.restTemplate.student.repository.StudentRepository;
import com.school.school.model.SchoolModel;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class StudentService implements StudentServiceInterface {

	private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
	@Autowired
	private StudentRepository repository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<StudentModel> createStudentInfo(List<StudentModel> model, HttpServletRequest request) {
		try {
			logger.info("thiis model {} is added successfully into the database ", model);
			return repository.saveAll(model);
		} catch (Exception e) {
			logger.error("this model {} is not added in to the database ", model.toString(), e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<StudentModel> getAllStudent() {
		try {
			List<StudentModel> listStudent = repository.findAll();
			return listStudent;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public StudentModel getStudentById(String id) {
		try {
			Optional<StudentModel> student = repository.findById(id);
			if (student.isPresent()) {

				StudentModel studentModel = student.get();

				// Fetch school details using RestTemplate
				String schoolServiceUrl = "http://localhost:9090/getById/" + studentModel.getId();

				ResponseEntity<SchoolModel> response = restTemplate.getForEntity(schoolServiceUrl, SchoolModel.class);

				if (response.getStatusCode() == HttpStatus.OK || response.getBody() != null) {
					studentModel.setSchoolModel(response.getBody());
				} else {
					throw new RuntimeException("School not found for ID: " + studentModel.getId());
				}
				logger.info("this is the student of this id :- {}", id);
				return studentModel;
			} else {
				logger.error("this student id not found in this list, {}", id);
				throw new RuntimeException("Student not found for ID: " + id);
			}
		} catch (Exception e) {
			logger.error("this student is not present in this list, {}", id, e);
			throw new RuntimeException("this student id is not present in the database list ", e);
		}
//		return null;

		// Optional<StudentModel> stModel = repository.findById(id);
//		if (stModel.isPresent()) {
//			return stModel.get();
//		}
//		throw new RuntimeException("Student is not found " + id);
//			
	}

}
