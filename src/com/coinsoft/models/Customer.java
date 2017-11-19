package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends Person {

    private int id;
    private String status;

    public Customer(String code, String dni, String name, String lastName, int age, String mail) {
        super(code, dni, name, lastName, age, mail);
        this.id = id;
        this.status = status;
    }

    public Customer(){

    }


    public static Customer from(ResultSet rs) {
        try {
            return new Customer(
                    rs.getString("code"),
                    rs.getString("dni"),
                    rs.getString("name"),
                    rs.getString("last_name"),
                    rs.getInt("age"),
                    rs.getString("mail")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public int getId() {
        return id;
    }

    public Customer setId(int id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Customer setStatus(String status) {
        this.status = status;
        return this;
    }
}