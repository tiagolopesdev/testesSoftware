package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.CollegeStudent;
import com.example.demo.repository.StudentRepository;

@Service
@Transactional
public class StudentService {
	
	@Autowired 
	private StudentRepository studentRepository;

	public void createStudent(String name, String lastName, String email) {
		CollegeStudent student = new CollegeStudent(name, lastName, email);
		int idIncrement = 0;
		student.setId(idIncrement+=idIncrement);
		studentRepository.save(student);
	}

}
