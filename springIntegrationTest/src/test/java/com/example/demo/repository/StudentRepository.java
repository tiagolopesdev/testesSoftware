package com.example.demo.repository;

import com.example.demo.models.CollegeStudent;

public interface StudentRepository {

	CollegeStudent findByEmailAddress(String string);
	
}
