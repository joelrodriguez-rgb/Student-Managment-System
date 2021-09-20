package com.sms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.app.entitys.Student;

public interface IStudentRepository extends JpaRepository<Student, Long>{

}
