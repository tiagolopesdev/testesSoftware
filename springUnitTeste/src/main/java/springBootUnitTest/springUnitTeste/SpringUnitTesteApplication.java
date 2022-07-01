package springBootUnitTest.springUnitTeste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import springBootUnitTest.springUnitTeste.dao.ApplicationDao;
import springBootUnitTest.springUnitTeste.models.CollegeStudent;
import springBootUnitTest.springUnitTeste.models.StudentGrades;
import springBootUnitTest.springUnitTeste.service.ApplicationService;

@SpringBootApplication
public class SpringUnitTesteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringUnitTesteApplication.class, args);
    }

    @Bean(name = "applicationExample")
    ApplicationService getApplicationService(){
        return new ApplicationService();
    }
    
    @Bean(name = "applicationDAO")
    ApplicationDao getApplicationDao(){
        return new ApplicationDao();
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
