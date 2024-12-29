package com.school.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.school.school.model.SchoolModel;
import com.school.school.repository.SchoolRepository;
import com.school.school.serviceInterface.SchoolServiceInterface;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class SchoolService implements SchoolServiceInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(SchoolService.class);

	@Autowired
	private SchoolRepository repository;

	@Override
	public SchoolModel insertSchool(SchoolModel model, HttpServletRequest request) {
		try {
			SchoolModel schoolModel = repository.save(model);
			LOGGER.info("this school inserted into database successfully");
			return schoolModel;
		} catch (Exception e) {
			LOGGER.error("School is not inerted", e);
			throw new RuntimeException("not inserted school", e);
//			e.printStackTrace();
		}
//		return null;
	}

	@Override
	public SchoolModel getById(Integer id, HttpServletRequest request) {
		try {
			SchoolModel schoolModel = repository.findById(id).get();
			if(schoolModel != null) {
				LOGGER.info("school is present by this id {}", id);
				return schoolModel;
			}
			else {
				LOGGER.error("school id is not present from  this ID {}",id);
				throw new RuntimeException("school is not present === else throw ");
			}
		} catch (Exception e) {
			LOGGER.error("school is not present from this id {}", id, e,HttpStatus.NOT_FOUND);
			 throw new RuntimeException("not found this id {}",e);
		}

//		return null;
	}

}
