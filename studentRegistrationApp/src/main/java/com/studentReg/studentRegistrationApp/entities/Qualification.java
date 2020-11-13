package com.studentReg.studentRegistrationApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.studentReg.studentRegistrationApp.types.qualification.QualificationRequest;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Qualification {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer qualification_id;

    @NonNull
    private String name;
    @NonNull
    private String code;

    @ManyToMany(mappedBy = "qualifications", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    Set<Module> modules = new HashSet<>();

    @ManyToMany(mappedBy = "qualifications", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<Student> students;

//    @OneToMany(mappedBy="qualification")
//    private Set<AcademicRecord> academicRecords;

    public Qualification(QualificationRequest qualificationRequest){
        this.name = qualificationRequest.getName().trim();
        this.code = qualificationRequest.getCode().trim();
    }

    public Qualification(){}

    public Integer getQualification_id() {
        return qualification_id;
    }

    public void setQualification_id(Integer qualification_id) {
        this.qualification_id = qualification_id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getCode() {
        return code;
    }

    public void setCode(@NonNull String code) {
        this.code = code;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

//    public Set<AcademicRecord> getAcademicRecords() {
//        return academicRecords;
//    }
//
//    public void setAcademicRecords(Set<AcademicRecord> academicRecords) {
//        this.academicRecords = academicRecords;
//    }
}
