package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Person {

    private int PersonId;
    private String code;
    private String dni;
    private String name;
    private String lastName;
    private int age;
    private String mail;
    private String personStatus;


    public Person(String code, String dni, String name, String lastName, int age, String mail,String personStatus) {
        this.code = code;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.mail = mail;
        this.setPersonStatus(personStatus);
    }
    public Person() {
    }

    public int getPersonId() {
        return PersonId;
    }

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

    public String getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(String personStatus) {
        this.personStatus = personStatus;
    }

    public static Person from(ResultSet rs) {
        try {
            return new Person(
                    rs.getString("code"),
                    rs.getString("dni"),
                    rs.getString("name"),
                    rs.getString("last_name"),
                    rs.getInt("age"),
                    rs.getString("mail"),
                    rs.getString("person_status")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}