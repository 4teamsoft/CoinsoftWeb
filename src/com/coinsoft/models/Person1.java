package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Person1 {
    private int personId;
    private String code;
    private String dni;
    private String name;
    private String lastName;
    private int age;
    private String mail;
    private String personStatus;

    public Person1(int personId, String code, String dni, String name, String lastName, int age, String mail, String personStatus) {
        this.personId = personId;
        this.code = code;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.mail = mail;
        this.personStatus = personStatus;
    }

    public Person1() {
    }


    public int getPersonId() {
        return personId;
    }

    public Person1 setPersonId(int personId) {
        this.personId = personId; return this;
    }

    public String getCode() {
        return code;
    }

    public Person1 setCode(String code) {
        this.code = code;return this;
    }

    public String getDni() {
        return dni;
    }

    public Person1 setDni(String dni) {
        this.dni = dni;return this;
    }

    public String getName() {
        return name;
    }

    public Person1 setName(String name) {
        this.name = name;return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Person1 setLastName(String lastName) {
        this.lastName = lastName;return this;
    }

    public int getAge() {
        return age;
    }

    public Person1 setAge(int age) {
        this.age = age;return this;
    }

    public String getMail() {
        return mail;
    }

    public Person1 setMail(String mail) {
        this.mail = mail;return this;
    }

    public String getPersonStatus() {
        return personStatus;
    }

    public Person1 setPersonStatus(String personStatus) {
        this.personStatus = personStatus;return this;
    }

    public static Person1 from(ResultSet rs) {
        try {
            return new Person1(
                    rs.getInt("person_id"),
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
