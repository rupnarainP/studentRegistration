package com.studentReg.studentRegistrationApp.types.qualification;

import org.springframework.lang.NonNull;

public class QualificationRequest {
    @NonNull
    private String name;
    @NonNull
    private String code;

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
