package com.studentReg.studentRegistrationApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class AcademicRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String test1Mark = "Not released";
    @NonNull
    private String test2Mark = "Not released";
    @NonNull
    private String assignmentMark = "Not released";
    @NonNull
    private String examMark = "Not released";
    @NonNull
    private String finalMark = "Not released";
    @NonNull
    private String supplementaryMark = "Not released";

    @OneToOne(mappedBy = "academicRecord", cascade = {CascadeType.ALL})
    @JsonBackReference
    private Module module;

//    @ManyToOne
//    @JoinColumn(name="qualification_id", referencedColumnName = "qualification_id", nullable=true)
//    private Qualification qualification;

    public AcademicRecord() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NonNull
    public String getTest1Mark() {
        return test1Mark;
    }

    public void setTest1Mark(@NonNull String test1Mark) {
        this.test1Mark = test1Mark;
    }

    @NonNull
    public String getTest2Mark() {
        return test2Mark;
    }

    public void setTest2Mark(@NonNull String test2Mark) {
        this.test2Mark = test2Mark;
    }

    @NonNull
    public String getAssignmentMark() {
        return assignmentMark;
    }

    public void setAssignmentMark(@NonNull String assignmentMark) {
        this.assignmentMark = assignmentMark;
    }

    @NonNull
    public String getExamMark() {
        return examMark;
    }

    public void setExamMark(@NonNull String examMark) {
        this.examMark = examMark;
    }

    @NonNull
    public String getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(@NonNull String finalMark) {
        this.finalMark = finalMark;
    }

    @NonNull
    public String getSupplementaryMark() {
        return supplementaryMark;
    }

    public void setSupplementaryMark(@NonNull String supplementaryMark) {
        this.supplementaryMark = supplementaryMark;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

//    public Qualification getQualification() {
//        return qualification;
//    }
//
//    public void setQualification(Qualification qualification) {
//        this.qualification = qualification;
//    }

}
