package com.school.school.serviceInterface;

import com.school.school.model.SchoolModel;

import jakarta.servlet.http.HttpServletRequest;

public interface SchoolServiceInterface {

	public SchoolModel insertSchool(SchoolModel model, HttpServletRequest request);

	public SchoolModel getById(Integer id, HttpServletRequest request);

}
