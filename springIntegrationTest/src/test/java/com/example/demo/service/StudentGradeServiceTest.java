package com.example.demo.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import com.example.demo.models.*;
import com.example.demo.repository.StudentRepository;

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentGradeServiceTest {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentService studentService;
    
	
	@BeforeEach
	void setup() {
		studentService.createStudent("Tiago", "Lopes", "tiagolopes@gmail.com"); 
	}
	
    @Test
    void shouldCreateStudentService() {    	    	   	    	
        CollegeStudent student = studentRepository.findByEmailAddress("tiagolopes@gmail.com");        
    	Assertions.assertEquals("tiagolopes@gmail.com", student.getEmailAddress(), "Find by email");
    }
    
}
