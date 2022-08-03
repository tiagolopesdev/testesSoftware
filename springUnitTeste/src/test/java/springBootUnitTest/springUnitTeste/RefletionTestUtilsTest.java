package springBootUnitTest.springUnitTeste;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

import springBootUnitTest.springUnitTeste.models.CollegeStudent;
import springBootUnitTest.springUnitTeste.models.StudentGrades;


@SpringBootTest(classes = SpringUnitTesteApplication.class)
public class RefletionTestUtilsTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent collegeStudent;

    @Autowired
    StudentGrades studentGrades;

    @BeforeEach
    void seUp() {              
        ReflectionTestUtils.setField(collegeStudent, "id", 1L);
        ReflectionTestUtils.setField(collegeStudent, "firstname", "Tiago");
        ReflectionTestUtils.setField(collegeStudent, "lastname", "Lopes");
        ReflectionTestUtils.setField(collegeStudent, "emailAddress", 
                "tiagolopes@gmail.com");
        ReflectionTestUtils.setField(collegeStudent, "studentGrades",
                new StudentGrades(new ArrayList<>(Arrays.asList(
                        100.0, 85.0, 76.50, 91.75))));
    }
    
    @Test
    void caseTestFieldClass() {
        Assertions.assertEquals(1L, ReflectionTestUtils.getField(
                collegeStudent, "id"));
        Assertions.assertNotEquals(1, ReflectionTestUtils.getField(
                collegeStudent, "id")); 
    }  
    
    @Test 
    void caseTestMethodClass() {
        Assertions.assertEquals("Tiago Lopes tem o id: "+1L,
                ReflectionTestUtils.invokeMethod(collegeStudent,
                        "getFirstNameAndId"));
        Assertions.assertTrue(ReflectionTestUtils.invokeMethod(collegeStudent,
                "getFirstNameAndId").equals("Tiago Lopes tem o id: 1"));        
    }
}
