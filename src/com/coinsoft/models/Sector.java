package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sector {
    private int id;
    private String name;
    private String detail;
    private String status;
    private Employe employe;
    private Customer customer;

    public Sector() {
    }

    public Sector(int id, String name, String detail, String status, Employe employe, Customer customer) {
        this.setId(id);
        this.setName(name);
        this.setDetail(detail);
        this.setStatus(status);
        this.setEmploye(employe);
        this.setCustomer(customer);
    }

    public int getId() {
        return id;
    }

    public Sector setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Sector setName(String name) {
        this.name = name;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public Sector setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Sector setStatus(String status) {
        this.status = status;
        return this;
    }

    public Employe getEmploye() {
        return employe;
    }

    public Sector setEmploye(Employe employe) {
        this.employe = employe;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Sector setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public static Sector from(ResultSet rs, EmployeesEntity employeesEntity, CustomersEntity customersEntity) {
        Sector sector = new Sector();
        try {
            return sector.setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .setDetail(rs.getString("detail"))
                    .setStatus(rs.getString("status"))
                    .setEmploye(employeesEntity.findById(rs.getInt("employe_id")))
                    .setCustomer(customersEntity.findById(rs.getInt("customer_id")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}