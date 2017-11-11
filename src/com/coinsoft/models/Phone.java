package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Phone {
    private int id;
    private String number;
    private String type;
    private String operator;
    private String status;
    private Customer customer;

    public Phone() {
    }

    public Phone(int id, String number, String type, String operator, String status, Customer customer) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.operator = operator;
        this.status = status;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Phone setId(int id) {
        this.id = id;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public Phone setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getType() {
        return type;
    }

    public Phone setType(String type) {
        this.type = type;
        return this;
    }

    public String getOperator() {
        return operator;
    }

    public Phone setOperator(String operator) {
        this.operator = operator;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Phone setStatus(String status) {
        this.status = status;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Phone setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public static Phone from(ResultSet rs, CustomersEntity customersEntity) {
        Phone phone = new Phone();
        try {
            return phone.setId(rs.getInt("phone_id")).setNumber(rs.getString("number")).setType(rs.getString("type"))
                    .setOperator(rs.getString("operator")).setStatus(rs.getString("status")).setCustomer(customersEntity.findById(rs.getInt("customer_id")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
