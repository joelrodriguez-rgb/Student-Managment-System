package com.sms.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sms.app.entitys.Student;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
		Student s1 = new Student("Jose", "hermandes", "joseH@yahoo.com", "1990-12-12");
		System.out.println(s1.getStudentYear());
		assertEquals(30, s1.getStudentYear());

	}

}
