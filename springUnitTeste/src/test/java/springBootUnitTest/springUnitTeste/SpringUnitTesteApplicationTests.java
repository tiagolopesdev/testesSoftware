package springBootUnitTest.springUnitTeste;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springBootUnitTest.models.CollegeStudent;
import springBootUnitTest.models.StudentGrades;

@SpringBootTest(classes = SpringUnitTesteApplication.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)        
class SpringUnitTesteApplicationTests {

    CollegeStudent collegeStudent;

    @Autowired
    StudentGrades studentGrades;

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
}
