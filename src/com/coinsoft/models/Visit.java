package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Visit {
    private int id;
    private String type;
    private Date dateTime;
    private int result;
    private int actionCode;
    private String status;
    private User user;
    private Customer customer;

    public Visit() {
    }

    public Visit(int id, String type, Date dateTime, int result, int actionCode, String status, User user, Customer customer) {
        this.id = id;
        this.type = type;
        this.dateTime = dateTime;
        this.result = result;
        this.actionCode = actionCode;
        this.status = status;
        this.user = user;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Visit setId(int id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Visit setType(String type) {
        this.type = type;
        return this;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Visit setDateTime(Date dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public int getResult() {
        return result;
    }

    public Visit setResult(int result) {
        this.result = result;
        return this;
    }

    public int getActionCode() {
        return actionCode;
    }

    public Visit setActionCode(int actionCode) {
        this.actionCode = actionCode;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Visit setStatus(String status) {
        this.status = status;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Visit setUser(User user) {
        this.user = user;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Visit setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public static Visit from(ResultSet rs, UsersEntity usersEntity, CustomersEntity customersEntity) {
        Visit visit = new Visit();
        try {
            return visit.setId(rs.getInt("id"))
                    .setType(rs.getString("type"))
                    .setDateTime(rs.getDate("date_time"))
                    .setResult(rs.getInt("result"))
                    .setActionCode(rs.getInt("action_code"))
                    .setStatus(rs.getString("status"))
                    .setUser(usersEntity.findById(rs.getInt("user_id")))
                    .setCustomer(customersEntity.findById(rs.getInt("customer_id")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

