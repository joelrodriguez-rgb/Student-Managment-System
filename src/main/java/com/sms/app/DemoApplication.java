package com.sms.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sms.app.entitys.Student;
import com.sms.app.repository.IStudentRepository;

@SpringBootApplication
public class DemoApplication
//implements CommandLineRunner
{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//
//	@Autowired
//	private IStudentRepository student;
//	
//	@Override
//	public void run(String... args) throws Exception {
//
//		/* public Student( @NotEmpty String firstName, @NotEmpty String lastName, @Email String email,
//			String dateOfBirth)**/
//		
//		Student student1 = new Student ("ramiro","keloke","asdas@asdas","1990-12-12");
//		
//		student.save(student1);
//		
//		
//		
//	}

}
