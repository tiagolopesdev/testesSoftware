package springBootUnitTest.springUnitTeste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import springBootUnitTest.models.CollegeStudent;
import springBootUnitTest.models.StudentGrades;

@SpringBootApplication
public class SpringUnitTesteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringUnitTesteApplication.class, args);
    }

    @Bean(name = "collegeStudent")
    @Scope(value = "prototype")
    CollegeStudent getCollegeStudent(){
        return new CollegeStudent();
    }
    
    @Bean(name = "studentGrades")
    @Scope(value = "prototype")
    StudentGrades getStudentGrades(){
        return new StudentGrades();
    }
}
