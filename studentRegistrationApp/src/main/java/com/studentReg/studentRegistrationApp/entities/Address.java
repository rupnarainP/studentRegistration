package com.studentReg.studentRegistrationApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.studentReg.studentRegistrationApp.types.address.AddressRequest;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String streetNumber;
    @NonNull
    private String streetName;
    @NonNull
    private String suburb;
    @NonNull
    private String city;
    @NonNull
    private String postalCode;
    @NonNull
    private String country;

    @OneToOne(mappedBy = "address", cascade = {CascadeType.ALL})
    @JsonBackReference
    private Student student;

    public Address(){}

    public Address(AddressRequest addressRequest){
        this.streetNumber = addressRequest.getStreetNumber().trim();
        this.streetName = addressRequest.getStreetName().trim();
        this.suburb = addressRequest.getSuburb().trim();
        this.city = addressRequest.getCity().trim();
        this.postalCode = addressRequest.getPostalCode().trim();
        this.country = addressRequest.getCountry().trim();
    }

    public Address(Address address){
        this.streetNumber = address.getStreetNumber().trim();
        this.streetName = address.getStreetName().trim();
        this.suburb = address.getSuburb().trim();
        this.city = address.getCity().trim();
        this.postalCode = address.getPostalCode().trim();
        this.country = address.getCountry().trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NonNull
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(@NonNull String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @NonNull
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(@NonNull String streetName) {
        this.streetName = streetName;
    }

    @NonNull
    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(@NonNull String suburb) {
        this.suburb = suburb;
    }

    @NonNull
    public String getCity() {
        return city;
    }

    public void setCity(@NonNull String city) {
        this.city = city;
    }

    @NonNull
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(@NonNull String postalCode) {
        this.postalCode = postalCode;
    }

    @NonNull
    public String getCountry() {
        return country;
    }

    public void setCountry(@NonNull String country) {
        this.country = country;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
