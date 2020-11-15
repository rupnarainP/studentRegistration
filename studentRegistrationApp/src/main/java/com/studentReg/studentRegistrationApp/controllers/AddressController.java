package com.studentReg.studentRegistrationApp.controllers;

import com.studentReg.studentRegistrationApp.entities.Address;
import com.studentReg.studentRegistrationApp.entities.Student;
import com.studentReg.studentRegistrationApp.services.AddressService;
import com.studentReg.studentRegistrationApp.types.address.AddressRequest;
import com.studentReg.studentRegistrationApp.types.student.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/address") // This means URL's start with /demo (after Application path)
public class AddressController {
    @Autowired
    AddressService addressService;

    @PostMapping(path="/addAddress/{studentNumber}") // Map ONLY POST Requests
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    String addNewStudent (@RequestBody AddressRequest newAddress, @PathVariable String studentNumber) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Address address = new Address(newAddress);

        addressService.save(address, studentNumber);
        return "Address added!";
    }

    @PutMapping(path="/updateAddress/{studentNumber}")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    String registerStudent (@RequestBody AddressRequest addressRequest, @PathVariable String studentNumber) {
        addressService.update(addressRequest, studentNumber);
        return "Address updated!";
    }

    @GetMapping(path="/findAll")
    @CrossOrigin(origins = "http://localhost:3000")
    public @ResponseBody
    List<Address> findAll() {
        // This returns a JSON or XML with the users
        return addressService.findAll();
    }
}
