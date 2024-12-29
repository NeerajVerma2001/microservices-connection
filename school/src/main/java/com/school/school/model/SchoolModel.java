package com.school.school.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "schoolData")
public class SchoolModel {

	@Id
	@Column(name = "school_id")
	private Integer id;
	
//	@Column(name = "school_name")
//	private String name;
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "school_location")
	private String location;
	
	@Column(name = "school_zipcode")
	private String zipCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
	
	

	public String getLocation() {
		return location;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
