package com.studentReg.studentRegistrationApp.types.address;

import com.studentReg.studentRegistrationApp.entities.Student;
import org.springframework.lang.NonNull;

public class AddressRequest {
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
}
