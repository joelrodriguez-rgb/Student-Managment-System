package com.sms.app.entitys;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@NotBlank(message = "el nombre no puede estar en blanco")
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@NotEmpty
	@NotBlank(message = "el apellido no puede estar en blanco")
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Email
	@NotEmpty
	@NotBlank(message = "el email no puede estar en blanco")
	@Column(name = "email")
	private String email;

	@Column(name = "day_birth")
	@NotNull
	@Past(message = "la fecha debe ser anterior a la anctual")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;

	@Column(name = "student_year")
	private Integer studentYear;

	public Student() {
	}

	public Student(@NotEmpty String firstName, @NotEmpty String lastName, @Email String email,
			@NotNull @Past LocalDate dateOfBirth) {
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
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
	private static Integer parseBirth(LocalDate dateOfBirth) {

		LocalDate localDateNow = LocalDate.now();

		Period period = Period.between(dateOfBirth, localDateNow);

		return (Integer) period.getYears();

	}

}
