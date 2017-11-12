package com.coinsoft.actions;

import com.opensymphony.xwork2.ActionSupport;

public class EmployeAction extends ActionSupport{
    private String username;
    private String password;
    private String type;
    private String dni;
    private String name;
    private String lastName;
    private int age;
    private String mail;

    public EmployeAction(String username, String password, String type, String dni, String name, String lastName, int age, String mail) {
        this.username = username;
        this.password = password;
        this.type = type;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return edad;
    }

    public void setAge(int edad) {
        this.edad = edad;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String execute() {
        return SUCCESS;
    }

}
