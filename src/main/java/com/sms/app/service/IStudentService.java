package com.sms.app.service;

import java.util.List;

import com.sms.app.entitys.Student;

public interface IStudentService {

	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	 void deleteStudentById(Long id);
	 
}
