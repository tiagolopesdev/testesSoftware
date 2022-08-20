package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.CollegeStudent;

@Repository
public interface StudentRepository extends CrudRepository<CollegeStudent, Integer>{
	
	public CollegeStudent findByEmailAddress(String string);
	
}
