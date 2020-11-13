package com.studentReg.studentRegistrationApp.controllers;

import com.studentReg.studentRegistrationApp.entities.Student;
import com.studentReg.studentRegistrationApp.services.StudentService;
import com.studentReg.studentRegistrationApp.types.student.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/studentReg") // This means URL's start with /demo (after Application path)
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(path="/addStudent") // Map ONLY POST Requests
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    String addNewStudent (@RequestBody StudentRequest newStudent) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Student student = new Student();
        student.setName(newStudent.getName());
        student.setSurName(newStudent.getSurName());
        student.setEmail(newStudent.getEmail());
        student.setStudentNumber(newStudent.getStudentNumber());
        student.setStudent_id(newStudent.getStudent_id());

        studentService.save(student);
        return "Student added!";
    }

    @PutMapping(path="/registerStudent/{studentNumber}/{qualificationCode}") // Map ONLY POST Requests
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    String registerStudent (@PathVariable String studentNumber, @PathVariable String qualificationCode) {

        studentService.update(studentNumber, qualificationCode);
        return "Student registered!";
    }

    @GetMapping(path="/findByStudentNumber")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody Student getStudentByStudentNumber(@RequestParam String studentNumber) {
        // This returns a JSON or XML with the users
        return studentService.findByStudentNumber(studentNumber);
    }

    @GetMapping(path="/findByStudentName")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody List<Student> getStudentByStudentName(@RequestParam String studentName) {
        // This returns a JSON or XML with the users
        return studentService.findByStudentName(studentName);
    }

    @GetMapping(path="/findAll")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    List<Student> findAll() {
        // This returns a JSON or XML with the users
        return studentService.findAll();
    }
}
