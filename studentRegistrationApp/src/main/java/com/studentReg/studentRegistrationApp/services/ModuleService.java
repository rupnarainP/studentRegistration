package com.studentReg.studentRegistrationApp.services;

import com.studentReg.studentRegistrationApp.entities.AcademicRecord;
import com.studentReg.studentRegistrationApp.entities.Module;
import com.studentReg.studentRegistrationApp.entities.Qualification;
import com.studentReg.studentRegistrationApp.repositories.ModuleRepository;
import com.studentReg.studentRegistrationApp.repositories.QualificationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ModuleService {
    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    QualificationRespository qualificationRespository;

    public void addNewModule(Module module, String qualificationCode){
        AcademicRecord academicRecord = new AcademicRecord();
        module.setAcademicRecord(academicRecord);
        Qualification qualification = qualificationRespository.findByCode(qualificationCode);
        module.setQualifications(Stream.of(qualification).collect(Collectors.toSet()));
        module.getQualifications().forEach(qualification1 -> qualification1.getModules().add(module));

        moduleRepository.save(module);
    }

    public Module findByCode(String code){
        Module module = moduleRepository.findByCode(code);

        return module;
    }

    public List<Module> findByName(String name){
        List<Module> modules = moduleRepository.findByNameLike(name);

        return modules;
    }

    public List<Module> findAll(){
        return moduleRepository.findAll();
    }
}
