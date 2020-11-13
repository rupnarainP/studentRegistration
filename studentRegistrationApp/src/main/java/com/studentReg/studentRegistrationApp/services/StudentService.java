package com.studentReg.studentRegistrationApp.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studentReg.studentRegistrationApp.entities.AcademicRecord;
import com.studentReg.studentRegistrationApp.entities.Module;
import com.studentReg.studentRegistrationApp.entities.Qualification;
import com.studentReg.studentRegistrationApp.entities.Student;
import com.studentReg.studentRegistrationApp.repositories.QualificationRespository;
import com.studentReg.studentRegistrationApp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private QualificationRespository qualificationRespository;

    @Autowired
    private EmailService emailService;

    public Student findByStudentNumber(String studentNumber){
        Student student = studentRepository.findByStudentNumber(studentNumber);
        return student;
    }

    public List<Student> findByStudentName(String studentName){
        List<Student> students = studentRepository.findByName(studentName);
        return students;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public void save(Student student){
        studentRepository.save(student);
    }

    public void update(String studentNumber, String qualificationCode){
        Student student = studentRepository.findByStudentNumber(studentNumber);
        Qualification qualification = qualificationRespository.findByCode(qualificationCode);
        Set<Qualification> qualificationSet = new HashSet<>();
        qualificationSet.add(qualification);
        student.setQualifications(qualificationSet);

        studentRepository.save(student);

        emailService.sendMail( "Registration complete", student);
    }

    public String toString(Student student){
         String result = "";

        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(student);
            Object j = mapper.readValue(json, Object.class);
            result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(j);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }
}

