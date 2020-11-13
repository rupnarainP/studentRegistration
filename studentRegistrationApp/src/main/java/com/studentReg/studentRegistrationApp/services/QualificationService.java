package com.studentReg.studentRegistrationApp.services;

import com.studentReg.studentRegistrationApp.entities.Qualification;
import com.studentReg.studentRegistrationApp.repositories.QualificationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationService {
    @Autowired
    QualificationRespository qualificationsRespository;

    public void addNewQualification(Qualification qualification){
        qualificationsRespository.save(qualification);
    }

    public Qualification findByCode(String qualification_code){
        Qualification qualification = qualificationsRespository.findByCode(qualification_code);

        return qualification;
    }

    public List<Qualification> findByName(String qualification_name){
        List<Qualification> qualifications = qualificationsRespository.findByNameLike(qualification_name);

        return qualifications;
    }

    public List<Qualification> findAll(){
        List<Qualification> qualifications = qualificationsRespository.findAll();

        return qualifications;
    }
}
