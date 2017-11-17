package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends Person {

    private int id;
    private String type;
    private String status;
    private int personId;


    public Customer(String code, String dni, String name, String lastName, int age, String mail, String type, String status) {
        super(code, dni, name, lastName, age, mail);
        this.type = type;
        this.status = status;
    }


    public static Customer from(ResultSet rs) {
        try {
            return new Customer(
                    rs.getString("code"),
                    rs.getString("dni"),
                    rs.getString("name"),
                    rs.getString("last_name"),
                    rs.getInt("age"),
                    rs.getString("mail"),
                    rs.getString("type"),
                    rs.getString("status")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

/*
    public int getId() {
        return id;
    }*/

    public String getType() {
        return type;
    }

    public Customer setType(String type) {
        this.type = type;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Customer setStatus(String status) {
        this.status = status;
        return this;
    }

    public int getPersonId() {
        return personId;
    }

    public Customer setPersonId(int personId) {
        this.personId = personId;
        return this;
    }
}