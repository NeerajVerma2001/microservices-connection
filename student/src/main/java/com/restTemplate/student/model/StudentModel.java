package com.restTemplate.student.model;

import com.school.school.model.SchoolModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "studentData")
public class StudentModel {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(name = "s_name")
	private String name;

	@Column(name = "s_subject")
	private String subject;
	
//	@Column(name = "s_schoolName")
//	private String schoolName;
	
	
	@Transient
    private SchoolModel schoolModel; // Not stored in the database

    public SchoolModel getSchoolModel() {
        return schoolModel;
    }

    public void setSchoolModel(SchoolModel schoolModel) {
        this.schoolModel = schoolModel;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

//	public String getSchoolName() {
//		return schoolName;
//	}
//
//	public void setSchoolName(String schoolName) {
//		this.schoolName = schoolName;
//	}

}
