package com.studentReg.studentRegistrationApp.repositories;

import com.studentReg.studentRegistrationApp.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByStudentNumber(String studentNumber);
    List<Student> findByName(String name);
}
