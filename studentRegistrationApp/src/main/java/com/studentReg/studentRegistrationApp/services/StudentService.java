package com.studentReg.studentRegistrationApp.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studentReg.studentRegistrationApp.entities.*;
import com.studentReg.studentRegistrationApp.entities.Module;
import com.studentReg.studentRegistrationApp.repositories.AddressRepository;
import com.studentReg.studentRegistrationApp.repositories.QualificationRespository;
import com.studentReg.studentRegistrationApp.repositories.StudentRepository;
import com.studentReg.studentRegistrationApp.types.student.StudentRequest;
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

    @Autowired
    private AddressRepository addressRepository;

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

//    public void save(Student student){
//        Integer id = studentRepository.findTopByOrderByIdDesc();
//        student.setStudentNumber((id + 1) + "");
//        studentRepository.save(student);
//    }

    public Student save(StudentRequest newStudent){
        Integer id = studentRepository.findTopByOrderByIdDesc().getId();
        Student student = new Student(newStudent);
        Address address = new Address(newStudent.getAddress());
        Address savedAddress = addressRepository.save(address);
        student.setStudentNumber((id + 1) + "");
        student.setAddress(savedAddress);
        Student addedStudent = studentRepository.save(student);
        address.setStudent(addedStudent);
        addressRepository.save(address);

        return addedStudent;
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

