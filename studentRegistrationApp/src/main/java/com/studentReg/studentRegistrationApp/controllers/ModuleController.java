package com.studentReg.studentRegistrationApp.controllers;

import com.studentReg.studentRegistrationApp.entities.Module;
import com.studentReg.studentRegistrationApp.services.ModuleService;
import com.studentReg.studentRegistrationApp.types.module.ModuleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/module") // This means URL's start with /demo (after Application path)
public class ModuleController {
    @Autowired
    ModuleService moduleService;

    @PostMapping(path="/addModule", consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    String addNewStudent (@RequestBody ModuleRequest newModule) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Module module = new Module(newModule);

        moduleService.addNewModule(module, newModule.getQualificationCode());
        return "Module added!";
    }

    @GetMapping(path="/findByCode")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody Module findByCode(@RequestParam String moduleCode) {
        // This returns a JSON or XML with the users
        return moduleService.findByCode(moduleCode);
    }

    @GetMapping(path="/findAll")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    List<Module> findAll() {
        // This returns a JSON or XML with the users
        return moduleService.findAll();
    }
}
