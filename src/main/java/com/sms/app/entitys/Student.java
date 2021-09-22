package com.sms.app.entitys;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@NotBlank
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Email
	@Column(name = "email")
	private String email;

	@NotEmpty
	@Column(name = "day_birth")
	private String dateOfBirth;

	@Column(name = "student_year")
	private Integer studentYear;

	public Student() {
	}

	public Student(@NotEmpty String firstName, @NotEmpty String lastName, @Email String email,
			@NotEmpty String dateOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	/********** GETTERS / SETTERS ***********/
	////////// ID////////////

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	////////// FIRST NAME////////////

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	////////// LAST NAME////////////

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	////////// EMAIL////////////

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	////////// BIRHT////////////
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.studentYear = parseBirth(dateOfBirth);
		this.dateOfBirth = dateOfBirth;
	}

	////////// STUDENT YEAR ////////////
	public void setStudentYear(Integer studentYear) {
		this.studentYear = studentYear;
	}

	public Integer getStudentYear() {
		return studentYear;
	}

	// ***************************************************************************//

	/**
	 * @return Integer
	 * 
	 *         metodo auxiliar, convierte el String dateOfBirth en un LocalDate para
	 *         luego poder calcular la edad
	 */
	private static Integer parseBirth(String dateOfBirth) {

		LocalDate birth = LocalDate.parse(dateOfBirth);
		LocalDate localDateNow = LocalDate.now();

		Period period = Period.between(birth, localDateNow);

		return (Integer) period.getYears();
	}

}
