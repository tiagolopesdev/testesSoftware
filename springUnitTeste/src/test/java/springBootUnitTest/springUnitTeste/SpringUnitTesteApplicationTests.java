package springBootUnitTest.springUnitTeste;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import springBootUnitTest.models.CollegeStudent;
import springBootUnitTest.models.StudentGrades;

@SpringBootTest(classes = SpringUnitTesteApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)        
class SpringUnitTesteApplicationTests {

    CollegeStudent collegeStudent;

    @Autowired
    StudentGrades studentGrades;
    
    @Autowired
    ApplicationContext context;

    @BeforeEach
    void setup() {
        studentGrades.setMathGradeResults(new ArrayList<>(Arrays
                .asList(100.0, 85.0, 76.50, 91.75)));
        collegeStudent = new CollegeStudent("Gabriel", "Soares",
                "gabriel@gmail.com", studentGrades);
    }

    @Test
    @Order(1)
    @DisplayName("Add grade results for student grades")
    void testAddGradeResultsForStudent() {
        Assertions.assertEquals(353.25, studentGrades
                .addGradeResultsForSingleClass(collegeStudent
                        .getStudentGrades().getMathGradeResults()));
    }
    
    @Test
    @Order(2)
    @DisplayName("Add grade results for student grades not equals")
    void testAddGradeResultsForStudentNotEquals() {
        Assertions.assertNotEquals(0, studentGrades
                .addGradeResultsForSingleClass(collegeStudent
                        .getStudentGrades().getMathGradeResults()));
    }
            
    @Test
    @Order(3)
    @DisplayName("Add grade results for student grades True")
    void testAddGradeResultsForStudentTrue() {
        Assertions.assertTrue(collegeStudent.getStudentGrades()
                .addGradeResultsForSingleClass(studentGrades
                        .getMathGradeResults()) > 300.0);
    }
    
    @Test
    @Order(4)
    @DisplayName("Method isGradeGreater true")
    void testIsGradeGreaterTrue(){
        Assertions.assertTrue(studentGrades.isGradeGreater(90, 70),
                "Parametro 1 menor que parametro 2.");
    }
    
    @Test
    @Order(5)
    @DisplayName("Method isGradeGreater false")
    void testIsGradeGreaterFalse(){
        Assertions.assertFalse(studentGrades.isGradeGreater(40, 70));
    }
    
    @Test
    @DisplayName("Create student without grade init")
    void createStudentWithoutGradesInit(){
        CollegeStudent student = context.getBean("collegeStudent", 
                CollegeStudent.class);        
        student.setFirstname("Lucas");
        student.setLastname("Silva");
        student.setEmailAddress("lucasSilva@gmail.com");
        Assertions.assertNotNull(student.getFirstname());
        Assertions.assertNotNull(student.getLastname());
        Assertions.assertNotNull(student.getEmailAddress());
        Assertions.assertNull(studentGrades
                .checkNull(student.getStudentGrades()));        
    }    
}
