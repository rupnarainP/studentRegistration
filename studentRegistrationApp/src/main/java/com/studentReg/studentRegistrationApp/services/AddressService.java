package com.studentReg.studentRegistrationApp.services;

import com.studentReg.studentRegistrationApp.entities.Address;
import com.studentReg.studentRegistrationApp.entities.Student;
import com.studentReg.studentRegistrationApp.repositories.AddressRepository;
import com.studentReg.studentRegistrationApp.repositories.StudentRepository;
import com.studentReg.studentRegistrationApp.types.address.AddressRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<Address> findAll(){
        return addressRepository.findAll();
    }

    public void save(Address address, String studentNumber){
        address.setStudent(studentRepository.findByStudentNumber(studentNumber));
        addressRepository.save(address);
    }

    public void update(AddressRequest addressRequest, String studentNumber){
        Address updatedAddress = new Address();
        Student student = studentRepository.findByStudentNumber(studentNumber);
        Optional<Address> address = addressRepository.findById(student.getAddress().getId());
        if(address.isPresent()){
            updatedAddress = address.get();
            updatedAddress.setStreetNumber(addressRequest.getStreetNumber());
            updatedAddress.setStreetName(addressRequest.getStreetName());
            updatedAddress.setSuburb(addressRequest.getSuburb());
            updatedAddress.setCity(addressRequest.getCity());
            updatedAddress.setPostalCode(addressRequest.getPostalCode());
            updatedAddress.setCountry(addressRequest.getCountry());
        }

        addressRepository.save(updatedAddress);
    }
}
