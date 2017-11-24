package com.coinsoft.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employe extends Person {

    private int id;
    private Date startDate;
    private Date endDate;


    public Employe(int id,String code, String dni, String name, String lastName, int age, String mail,String status, java.util.Date startDate, java.util.Date endDate) {
        super(id,code, dni, name, lastName, age, mail,status);
        this.id=id;
        this.startDate = (Date)startDate;
        this.endDate = (Date)endDate;
    }

    public Employe() {

    }


    public Date getStartDate() {
        return startDate;
    }

    public Employe setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Employe setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }


    public static Employe from(ResultSet rs) {
        try {
            return new Employe(
                    rs.getInt("id"),
                    rs.getString("code"),
                    rs.getString("dni"),
                    rs.getString("name"),
                    rs.getString("last_name"),
                    rs.getInt("age"),
                    rs.getString("mail"),
                    rs.getString("status"),
                    rs.getDate("startDate"),
                    rs.getDate("endDate")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}