package springBootUnitTest.springUnitTeste;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springBootUnitTest.models.CollegeStudent;
import springBootUnitTest.models.StudentGrades;

@SpringBootTest(classes = SpringUnitTesteApplication.class)
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
    @DisplayName("Add grade results for student grades")
    void testAddGradeResultsForStudent() {
        Assertions.assertEquals(353.25, studentGrades
                .addGradeResultsForSingleClass(collegeStudent
                        .getStudentGrades().getMathGradeResults()));
    }
}
