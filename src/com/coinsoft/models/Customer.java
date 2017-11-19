package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends Person {

    private int id;
    private String status;

    public Customer(int personId,String code, String dni, String name, String lastName, int age, String mail, String status) {
        super(personId,code, dni, name, lastName, age, mail);
        this.id = personId;
        this.status = status;
    }

    public Customer(){
    }

    public int getId() {
        return id;
    }
    //public Customer setId(int id) { this.id = id; return this; }

    public String getStatus() {
        return status;
    }
    public Customer setStatus(String status) { this.status = status; return this; }


    public static Customer from(ResultSet rs) {
        try {
            return new Customer(
                    rs.getInt(Person.from(rs).getPersonId()),
                    rs.getString("code"),
                    rs.getString("dni"),
                    rs.getString("name"),
                    rs.getString("last_name"),
                    rs.getInt("age"),
                    rs.getString("mail"),
                    rs.getString("status")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


}