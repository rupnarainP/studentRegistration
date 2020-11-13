package com.studentReg.studentRegistrationApp.repositories;

import com.studentReg.studentRegistrationApp.entities.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {
    List<Module> findByNameLike(String name);

    Module findByCode(String code);
}
