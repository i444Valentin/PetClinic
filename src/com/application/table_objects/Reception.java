package com.application.table_objects;

import java.util.Date;

public class Reception {
    private Date date;
    private String status;
    private String pet;
    private String doctor;
    private String specilization;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getSpecilization() {
        return specilization;
    }

    public void setSpecilization(String specilization) {
        this.specilization = specilization;
    }

    public Reception(Date date, String status, String pet, String doctor, String specilization) {
        this.date = date;
        this.status = status;
        this.pet = pet;
        this.doctor = doctor;
        this.specilization = specilization;
    }
}
