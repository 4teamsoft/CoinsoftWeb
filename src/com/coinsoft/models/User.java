package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends Employe{

    private int id;
    private String user;
    private String password;
    private int type;
    private String status;
    private int employeId;


    public User() {
    }

    public static User from(ResultSet rs) {
        try {
            return new Customer(
                    rs.getString("code"),
                    rs.getString("dni"),
                    rs.getString("name"),
                    rs.getString("last_name"),
                    rs.getInt("age"),
                    rs.getString("mail"),
                    rs.getInt("id"),
                    rs.getString("status")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
