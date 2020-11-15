package com.studentReg.studentRegistrationApp.repositories;

import com.studentReg.studentRegistrationApp.entities.Address;
import com.studentReg.studentRegistrationApp.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    Address findByStudent(Student student);
}
