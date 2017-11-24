package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends Person {

    private int id;



    public Customer(int id,String code, String dni, String name, String lastName, int age, String mail,String status) {
        super(id,code, dni, name, lastName, age, mail,status);
        this.id=id;
    }

    public Customer(){

    }


    public static Customer from(ResultSet rs ) {
        try {
            return new Customer(
                    rs.getInt("id"),
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