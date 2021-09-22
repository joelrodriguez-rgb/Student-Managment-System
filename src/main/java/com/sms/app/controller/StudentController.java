package com.sms.app.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.sms.app.entitys.Student;
import com.sms.app.service.IStudentService;

@Controller
public class StudentController {

	private IStudentService studentService;

	public StudentController(IStudentService studentService) {
		super();
		this.studentService = studentService;
	}

	/****************************
	 * METODOS GET
	 ****************************/

	/////////////////////// VISTA PRINCIPAL, LISTA ESTUDIANTES ///////////////////
	@GetMapping("/students")
	public String listStudents(Model model) {

		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}

	/////////////////////// AGREGAR ESTUDIANTE ///////////////////
	@GetMapping("/students/addStudent")
	public String createStdentForm(Model model) {

		Student student = new Student();
		model.addAttribute("student", student);

		return "addStudent";
	}

	/////////////////////// EDITAR ESTUDIANTE ///////////////////
	@GetMapping("/students/update_Student/{id}")
	public String updateStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "update_Student";
	}

	/////////////////////// ELIMINAR ESTUDIANTE ///////////////////
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {

		studentService.deleteStudentById(id);
		return "redirect:/students";
	}

	/////////////////////// DETALLES DE ESTUDIANTE ///////////////////
	@GetMapping("/students/detail_Student/{id}")
	public String detailStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentById(id));
		return "detail_Student";
	}

	/****************************
	 * METODOS POST
	 ****************************/

	// recive los datos del nuevo estudiante y los guarda
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") @Valid Student student, BindingResult result) {

		if (result.hasErrors()) {
			return "addStudent";
		}

		studentService.saveStudent(student);
		return "redirect:/students";
	}

	// actualiza los datos del estudiante
	// recive el id por la ruta
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student) {

		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setDateOfBirth(student.getDateOfBirth());

		// save update student
		studentService.saveStudent(existingStudent);
		return "redirect:/students";
	}

}
