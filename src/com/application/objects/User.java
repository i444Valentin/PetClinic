package com.application.objects;

import java.util.Date;

public class User {
    private String firstname;
    private String lastname;
    private String patronymic;
    private Date birthdate;
    private Long polis;
    private String residence;
    private Boolean gender; //Пол: 1 - мужской 0 - женский
    private String login;
    private String password;

    public User(String firstname, String lastname, String patronymic, Date birthdate, Long polis, String residence, Boolean gender, String login, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.polis = polis;
        this.residence = residence;
        this.gender = gender;
        this.login = login;
        this.password = password;
    }

    public User() { }



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Long getPolis() {
        return polis;
    }

    public void setPolis(Long polis) {
        this.polis = polis;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
