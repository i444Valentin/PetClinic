package com.application.table_objects;

import java.util.Date;

public class HReception {

    private Date hDate;
    private String hStatus;
    private String hPet;
    private String hDoctor;
    private String hSpecilization;
    private String hDoneStatus;

    public Date gethDate() {
        return hDate;
    }

    public void sethDate(Date hDate) {
        this.hDate = hDate;
    }

    public String gethStatus() {
        return hStatus;
    }

    public void sethStatus(String hStatus) {
        this.hStatus = hStatus;
    }

    public String gethPet() {
        return hPet;
    }

    public void sethPet(String hPet) {
        this.hPet = hPet;
    }

    public String gethDoctor() {
        return hDoctor;
    }

    public void sethDoctor(String hDoctor) {
        this.hDoctor = hDoctor;
    }

    public String gethSpecilization() {
        return hSpecilization;
    }

    public void sethSpecilization(String hSpecilization) {
        this.hSpecilization = hSpecilization;
    }

    public String gethDoneStatus() {
        return hDoneStatus;
    }

    public void sethDoneStatus(String hDoneStatus) {
        this.hDoneStatus = hDoneStatus;
    }

    public HReception(Date hDate, String hStatus, String hPet, String hDoctor, String hSpecilization, String hDoneStatus) {
        this.hDate = hDate;
        this.hStatus = hStatus;
        this.hPet = hPet;
        this.hDoctor = hDoctor;
        this.hSpecilization = hSpecilization;
        this.hDoneStatus = hDoneStatus;
    }
}
