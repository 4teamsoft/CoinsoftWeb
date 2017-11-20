package com.coinsoft.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends Employe{

    private String user;
    private String password;
    private String type;
    private String status;
    private int employeId;


    public User() {
    }

    public User(String user, String password, String type, String status, int employeId) {
        this.user = user;
        this.password = password;
        this.type = type;
        this.status = status;
        this.employeId = employeId;
    }

    public User(int personId,String code, String dni, String name, String lastName, int age, String mail,String personStatus,Date startDate, Date endDate, String employeStatus, String user, String password, String type, String status, int employeId) {
        super(personId,code, dni, name, lastName, age, mail,personStatus, startDate, endDate, employeStatus);

        this.user = user;
        this.password = password;
        this.type = type;
        this.status = status;
        this.employeId = employeId;
    }

    public static User from(ResultSet rs) {
        try {
            return new User(
                    rs.getInt("person_id"),
                    rs.getString("code"),
                    rs.getString("dni"),
                    rs.getString("name"),
                    rs.getString("last_name"),
                    rs.getInt("age"),
                    rs.getString("mail"),
                    rs.getString("personStatus"),
                    rs.getDate("startDate"),
                    rs.getDate("endDate"),
                    rs.getString("employeStatus"),
                    rs.getString("user"),
                    rs.getString("password"),
                    rs.getString("type"),
                    rs.getString("status"),
                    rs.getInt("employeId")

            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

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

    public int getEmployeId() {
        return employeId;
    }

    public User setEmployeId(int employeId) {
        this.employeId = employeId;
        return this;
    }
}
