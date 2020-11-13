package com.studentReg.studentRegistrationApp.types.student;

import org.springframework.lang.NonNull;

public class StudentRequest {
    @NonNull
    private String name;
    @NonNull
    private String surName;
    @NonNull
    private String email;
    @NonNull
    private String studentNumber;
    @NonNull
    private String student_id;

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getSurName() {
        return surName;
    }

    public void setSurName(@NonNull String surName) {
        this.surName = surName;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(@NonNull String studentNumber) {
        this.studentNumber = studentNumber;
    }

    @NonNull
    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(@NonNull String student_id) {
        this.student_id = student_id;
    }
}
