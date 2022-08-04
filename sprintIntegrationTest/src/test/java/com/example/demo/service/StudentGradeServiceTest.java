package com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import com.example.demo.models.*;
import com.example.demo.repository.StudentRepository;

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentGradeServiceTest {
	
	StudentRepository studentRepository;
    
    @Test
    void shouldCreateStudentService() {
        studentService.createStudent("Tiago", "Lopes", "tiagolopes@gmail.com");
        CollegeStudent student = studentRepository.findByEmailAddress("tiagolopes@gmail.com");
        Assertions.assertEquals("tiagolopes@gmail.com", student.getEmailAddress(), "Find by email");
    }
    
}
