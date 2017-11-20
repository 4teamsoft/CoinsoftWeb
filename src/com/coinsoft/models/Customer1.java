package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer1 extends Person1 {

    private int id;
    private String status;

    public Customer1(int personId,String code, String dni, String name, String lastName, int age, String mail,String personStatus,String status) {
        super(personId,code, dni, name, lastName, age, mail,personStatus);
        this.id = personId;
        this.status = status;
    }

    public Customer1(){

    }

    public int getId() {
        return id;
    }
    public Customer1 setId(int id) { this.id = id; return this; }

    public String getStatus() {
        return status;
    }

    public Customer1 setStatus(String status) {
        this.status = status;
        return this;
    }

    public static Customer1 from(ResultSet rs) {
        try {
            return new Customer1(
                    //rs.getInt("person_id"),
                    rs.getInt(String.valueOf(Person1.from(rs).setPersonId(rs.getInt("person_id")))),
                    //rs.getString("code"),
                    rs.getString(String.valueOf(Person1.from(rs).setCode(rs.getString("code")))),
                    //rs.getString("dni"),
                    rs.getString(String.valueOf(Person1.from(rs).setDni(rs.getString("dni")))),
                    //rs.getString("name"),
                    rs.getString(String.valueOf(Person1.from(rs).setDni(rs.getString("name")))),
                    // rs.getString("last_name"),
                    rs.getString(String.valueOf(Person1.from(rs).setDni(rs.getString("last_name")))),
                    //rs.getInt("age"),
                    rs.getInt(String.valueOf(Person1.from(rs).setPersonId(rs.getInt("age")))),
                    //rs.getString("mail"),
                    rs.getString(String.valueOf(Person1.from(rs).setDni(rs.getString("mail")))),
                   // rs.getString("person_status"),
                    rs.getString(String.valueOf(Person1.from(rs).setDni(rs.getString("person_status")))),

                    rs.getString("status")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


}