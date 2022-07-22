/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package springBootUnitTest.springUnitTeste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import springBootUnitTest.springUnitTeste.dao.ApplicationDao;
import springBootUnitTest.springUnitTeste.models.CollegeStudent;
import springBootUnitTest.springUnitTeste.models.StudentGrades;
import springBootUnitTest.springUnitTeste.service.ApplicationService;

/**
 *
 * @author tiagolopes
 */
@SpringBootTest(classes = SpringUnitTesteApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent collegeStudent;

    @Autowired
    StudentGrades studentGrades;

    @MockBean
    private ApplicationDao applicationDao;

    @Autowired
    private ApplicationService applicationService;

    @BeforeEach
    void setup() {
        collegeStudent = new CollegeStudent("Tiago",
                "Lopes", "saxtiago14@gmail.com", studentGrades);
    }

    @Test
    @DisplayName("When & Verify")
    void assertEqualsTestAddGrades() {
        when(applicationDao.addGradeResultsForSingleClass(
                studentGrades.getMathGradeResults())).thenReturn(300.00);
        Assertions.assertEquals(300, applicationService
                .addGradeResultsForSingleClass(collegeStudent
                        .getStudentGrades().getMathGradeResults()));
        verify(applicationDao).addGradeResultsForSingleClass(studentGrades
                .getMathGradeResults());
        verify(applicationDao, Mockito.times(1)).addGradeResultsForSingleClass(
                studentGrades.getMathGradeResults());
    }

    @Test
    @DisplayName("Find GPA")
    void assertEqualsFindGpa() {
        when(applicationDao.findGradePointAverage(studentGrades
                .getMathGradeResults())).thenReturn(90.0);
        Assertions.assertEquals(90.0, applicationService.findGradePointAverage(
                collegeStudent.getStudentGrades().getMathGradeResults()));
    }

    @Test
    @DisplayName("Not Null")
    void assertNotNull() {
        when(applicationDao.checkNull(studentGrades
                .getMathGradeResults())).thenReturn(true);
        Assertions.assertNotNull(applicationService.checkNull(collegeStudent
                .getStudentGrades().getMathGradeResults()));
    }

    @Test
    @DisplayName("Throw runtime error")
    void throwRuntimeError() {
        CollegeStudent nullStudent = (CollegeStudent) context
                .getBean("collegeStudent");
        doThrow(new RuntimeException()).when(applicationDao)
                .checkNull(nullStudent);
        Assertions.assertThrows(RuntimeException.class, () -> {
            applicationService.checkNull(nullStudent);
        });
        verify(applicationDao, times(1)).checkNull(nullStudent);
    }

}
