package com.studentReg.studentRegistrationApp.types.qualification;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.studentReg.studentRegistrationApp.entities.Module;
import com.studentReg.studentRegistrationApp.entities.Qualification;
import com.studentReg.studentRegistrationApp.entities.Student;
import org.springframework.lang.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QualificationResponse {

    @NonNull
    private String name;
    @NonNull
    private String code;
    @NonNull
    Set<Module> modules = new HashSet<>();
    @NonNull
    private Set<Student> students;

    List<Qualification> qualifications;

    public QualificationResponse(Qualification qualification){
        this.name = qualification.getName().trim();
        this.code = qualification.getCode().trim();
        this.modules = qualification.getModules();
        this.students = qualification.getStudents();
    }

    public QualificationResponse(List<Qualification> qualifications){
        this.qualifications = new ArrayList<>();
        for(Qualification q : qualifications){
            this.qualifications.add(q);
        }
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

    @NonNull
    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(@NonNull Set<Module> modules) {
        this.modules = modules;
    }

    @NonNull
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(@NonNull Set<Student> students) {
        this.students = students;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }
}
