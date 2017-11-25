package com.coinsoft.actions;

import com.opensymphony.xwork2.ActionSupport;


public class CustomerAction extends ActionSupport{


    private int id;
    private String code;
    private String dni;
    private String name;
    private String lastName;
    private int age;
    private String mail;


    public CustomerAction(int id, String code, String dni, String name, String lastName, int age, String mail) {
        this.id = id;
        this.code = code;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.mail = mail;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
