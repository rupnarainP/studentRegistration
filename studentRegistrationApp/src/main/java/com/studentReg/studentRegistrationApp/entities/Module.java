package com.studentReg.studentRegistrationApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.studentReg.studentRegistrationApp.types.module.ModuleRequest;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Module {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer module_id;

    @NonNull
    private String name;
    @NonNull
    private String code;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "qualification_module",
            joinColumns = @JoinColumn(name = "module_id", referencedColumnName = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "qualification_id", referencedColumnName = "qualification_id"))
    @JsonBackReference
    Set<Qualification> qualifications;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "academicRecord_id", referencedColumnName = "id")
    private AcademicRecord academicRecord;

    public Module(){ }

    public Module(ModuleRequest moduleRequest){
        this.name = moduleRequest.getName().trim();
        this.code = moduleRequest.getCode().trim();
    }

    public Integer getModule_id() {
        return module_id;
    }

    public void setModule_id(Integer module_id) {
        this.module_id = module_id;
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

    public Set<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(Set<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public AcademicRecord getAcademicRecord() {
        return academicRecord;
    }

    public void setAcademicRecord(AcademicRecord academicRecord) {
        this.academicRecord = academicRecord;
    }
}
