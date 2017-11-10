package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int id;
    private String user;
    private String password;
    private int type;
    private String status;
    private Person person;

    public User() {
    }

    public User(int id, String user, String password, int type, String status, Person person) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.type = type;
        this.status = status;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public User setId(int id) {
        this.id = id;
        return this;
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

    public int getType() {
        return type;
    }

    public User setType(int type) {
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

    public Person getPerson() {
        return person;
    }

    public User setPerson(Person person) {
        this.person = person;
        return this;
    }

    public static User from(ResultSet rs){
        try{
            return new User(
                    rs.getInt("user_id"),
                    rs.getString("user"),
                    rs.getString("password"),
                    rs.getString("type"),
                    rs.getString("status1"));

            } catch (SQLException e){
                e.printStackTrace();
            }
    }
}
