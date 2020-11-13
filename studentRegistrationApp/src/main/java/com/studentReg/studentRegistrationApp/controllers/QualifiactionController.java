package com.studentReg.studentRegistrationApp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studentReg.studentRegistrationApp.entities.Qualification;
import com.studentReg.studentRegistrationApp.entities.Student;
import com.studentReg.studentRegistrationApp.services.QualificationService;
import com.studentReg.studentRegistrationApp.types.qualification.QualificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path="/qualification") // This means URL's start with /demo (after Application path)
public class QualifiactionController {

    @Autowired
    QualificationService qualificationService;

    @PostMapping(path="/addQualification") // Map ONLY POST Requests
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    String addNewStudent (@RequestBody QualificationRequest newQualification) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
    Qualification qualification = new Qualification(newQualification);

        qualificationService.addNewQualification(qualification);
        return "Qualification added!";
    }

    @GetMapping(path="/findByCode")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody Qualification findByCode(@RequestParam String qualificationCode) {
        // This returns a JSON or XML with the users
        return qualificationService.findByCode(qualificationCode);
    }

    @GetMapping(path="/findAll")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    List<Qualification> findAll() {
        // This returns a JSON or XML with the users
        return qualificationService.findAll();
    }

    @GetMapping(path="/findByName/{qualificationName}")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    List<Qualification> findByName(@PathVariable String qualificationName) {
        // This returns a JSON or XML with the users
        return qualificationService.findByName(qualificationName);
    }
}
