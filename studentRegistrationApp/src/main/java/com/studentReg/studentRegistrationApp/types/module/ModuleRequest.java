package com.studentReg.studentRegistrationApp.types.module;

import org.springframework.lang.NonNull;

public class ModuleRequest {
    @NonNull
    private String name;
    @NonNull
    private String code;

    @NonNull
    private String qualificationCode;

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

    @NonNull
    public String getQualificationCode() {
        return qualificationCode;
    }

    public void setQualificationCode(@NonNull String qualificationCode) {
        this.qualificationCode = qualificationCode;
    }
}
