package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {

    private int id;
    private String code;
    private String dni;
    private String name;
    private String lastName;
    private int age;
    private String mail;

    public Person(String code, String dni, String name, String lastName, int age, String mail) {

        this.code = code;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.mail = mail;
    }

    public Person() {
    }


    /*public Person setId(int id) {
        this.person_id = id;
        return this;
    }*/

    public String getCode() {
        return code;
    }

    public Person setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDni() {
        return dni;
    }

    public Person setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public Person setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public static Person from(ResultSet rs) {
        try {
            return new Person(
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
}
