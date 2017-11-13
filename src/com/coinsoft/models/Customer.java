package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends Person {

    private int id;
    private String type;

    public Customer(String code, String dni, String name, String lastName, int age, String mail, String status, String type) {
        super(code, dni, name, lastName, age, mail, status);
        this.type = type;
    }

    public Customer() {
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


    public int getId() {
        return id;
    }

}
