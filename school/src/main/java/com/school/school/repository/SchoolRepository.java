package com.school.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.school.model.SchoolModel;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolModel, Integer> {

}
