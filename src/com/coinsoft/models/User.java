package com.coinsoft.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private int id;
    private String user;
    private String password;
    private String type;
    private String status;
    private Employe employe;


    public User() {
    }

    public User(int id, String user, String password, String type, String status, Employe employe) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.type = type;
        this.status = status;
        this.employe = employe;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id; return this;
    }

    public String getUser() {
        return user;
    }

    public User setUser(String user) {
        this.user = user;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getType() {
        return type;
    }

    public User setType(String type) {
        this.type = type;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public User setStatus(String status) {
        this.status = status;
        return this;
    }

    public Employe getEmploye() {
        return employe;
    }

    public User setEmploye(Employe employe) {
        this.employe = employe; return this;
    }


    public static User from(ResultSet rs, EmployeesEntity employeesEntity) {
        User user = new User();
        try {
            return user.setId(rs.getInt("id"))
                    .setUser(rs.getString("user"))
                    .setPassword(rs.getString("pwd"))
                    .setType(rs.getString("type"))
                    .setStatus(rs.getString("status"))
                    .setEmploye(employeesEntity.findById(rs.getInt("employe_id")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }





}
