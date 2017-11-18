package com.coinsoft.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employe extends Person {

    private Date startDate;
    private Date endDate;
    private String personId;

    public Employe(String code, String dni, String name, String lastName, int age, String mail, Date startDate, Date endDate, String personId) {
        super(code, dni, name, lastName, age, mail);
        this.startDate = startDate;
        this.endDate = endDate;
        this.personId = personId;
    }

    public Employe() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public Employe setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Employe setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPersonId() {
        return personId;
    }

    public Employe setPersonId(String personId) {
        this.personId = personId;
    }
}