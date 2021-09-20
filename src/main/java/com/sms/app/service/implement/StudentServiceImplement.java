package com.sms.app.service.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sms.app.entitys.Student;
import com.sms.app.repository.IStudentRepository;
import com.sms.app.service.IStudentService;

@Service
public class StudentServiceImplement implements IStudentService {

	// inyecta la capa de repo para poder acceder a los metodos de DB
	private IStudentRepository studentRepository;

	public StudentServiceImplement(IStudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}

}
