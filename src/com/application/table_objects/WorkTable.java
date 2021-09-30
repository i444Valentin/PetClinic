package com.application.table_objects;

public class WorkTable {
    
    private Integer id;

    private String date;
    private String FIOPacient;
    private String petName;
    private String petBreed;
    private String petGender;
    private String FIODoctor;
    private String employeeDoctor;



    public WorkTable(Integer id, String date, String FIOPacient, String petName, String petBreed,
                     String petGender, String FIODoctor, String employeeDoctor) {
        this.id = id;
        this.date = date;
        this.FIOPacient = FIOPacient;
        this.petName = petName;
        this.petBreed = petBreed;
        this.petGender = petGender;
        this.FIODoctor = FIODoctor;
        this.employeeDoctor = employeeDoctor;
    }

    public WorkTable() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFIOPacient() {
        return FIOPacient;
    }

    public void setFIOPacient(String FIOPacient) {
        this.FIOPacient = FIOPacient;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    public String getPetGender() {
        return petGender;
    }

    public void setPetGender(String petGender) {
        this.petGender = petGender;
    }

    public String getFIODoctor() {
        return FIODoctor;
    }

    public void setFIODoctor(String FIODoctor) {
        this.FIODoctor = FIODoctor;
    }

    public String getEmployeeDoctor() {
        return employeeDoctor;
    }

    public void setEmployeeDoctor(String employeeDoctor) {
        this.employeeDoctor = employeeDoctor;
    }

    
    public boolean isNullFields(){
        return id == null && date == null && FIOPacient == null &&
                petName == null && petBreed == null && petGender == null && FIODoctor == null &&
                employeeDoctor == null;
    }
}
