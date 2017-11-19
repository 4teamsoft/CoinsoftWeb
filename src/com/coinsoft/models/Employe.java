package com.coinsoft.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employe extends Person {

    private int id;
    private Date startDate;
    private Date endDate;
    private String employeStatus;

    public Employe(int personId,String code, String dni, String name, String lastName, int age, String mail, Date startDate, Date endDate, String employeStatus) {
        super(personId,code, dni, name, lastName, age, mail);
        this.id=personId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeStatus = employeStatus;
    }

    public Employe() {
    }


    public int getId() { return id; }
    //public Employe setId(int id) { this.id = id; return this; }

    public Date getStartDate() {
        return startDate;
    }

    public Employe setStartDate(Date startDate) { this.startDate = startDate; return this; }

    public Date getEndDate() {
        return endDate;
    }

    public Employe setEndDate(Date endDate) { this.endDate = endDate; return this; }

    public String getEmployeStatus() {
        return employeStatus;
    }

    public Employe setEmployeStatus(String employeStatus) { this.employeStatus = employeStatus; return this; }


    public static Employe from(ResultSet rs) {
        try {
            return new Employe(
                    rs.getInt(Person.from(rs).getPersonId()),
                    rs.getString("code"),
                    rs.getString("dni"),
                    rs.getString("name"),
                    rs.getString("last_name"),
                    rs.getInt("age"),
                    rs.getString("mail"),
                    rs.getDate("startDate"),
                    rs.getDate("endDate"),
                    rs.getString("employeStatus")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}