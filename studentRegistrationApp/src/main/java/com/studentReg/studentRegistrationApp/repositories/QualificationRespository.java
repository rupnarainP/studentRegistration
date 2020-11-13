package com.studentReg.studentRegistrationApp.repositories;

import com.studentReg.studentRegistrationApp.entities.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QualificationRespository extends JpaRepository<Qualification, Integer> {
    List<Qualification> findByNameLike(String name);

    Qualification findByCode(String code);
}
