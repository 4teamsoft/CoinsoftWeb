package com.coinsoft.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employe extends Person {

    private int id;
    private String startDate;
    private String endDate;


    public Employe(int id,String code, String dni, String name, String lastName, int age, String mail,String status, String startDate, String endDate) {
        super(id,code, dni, name, lastName, age, mail,status);
        this.id=id;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Employe() { }

    public String getStartDate() {
        return startDate;
    }
    public Employe setStartDate(String startDate) { this.startDate = startDate; return this; }

    public String getEndDate() {
        return endDate;
    }
    public Employe setEndDate(String endDate) { this.endDate = endDate; return this; }


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
                    rs.getString("start_date"),
                    rs.getString("end_date")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


}