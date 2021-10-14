package com.application.table_objects;

public class ListDoctors {

    private String doctor;
    private String specilization;


    public ListDoctors(String doctor, String specilization) {
        this.doctor = doctor;
        this.specilization = specilization;
    }

    public ListDoctors() {

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

    public boolean isNullFields(){
        return doctor == null && specilization == null;
    }
}
