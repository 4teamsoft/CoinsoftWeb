package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Visit {
    private int id;
    private String type;
    private String dateTime;
    private int result;
    private int actionCode;
    private String collectionStage;
    private String status;
    private Employe employe;
    private Customer customer;

    public Visit() {
    }

    public Visit(int id, String type, String dateTime, int result, int actionCode, String collectionStage,String status, Employe employe, Customer customer) {
        this.id = id;
        this.type = type;
        this.dateTime = dateTime;
        this.result = result;
        this.actionCode = actionCode;
        this.collectionStage=collectionStage;
        this.status = status;
        this.employe = employe;
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

    public String getDateTime() {
        return dateTime;
    }

    public Visit setDateTime(String dateTime) {
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

    public String getCollectionStage() {
        return collectionStage;
    }

    public Visit setCollectionStage(String collectionStage) {
        this.collectionStage = collectionStage; return this;
    }

    public String getStatus() {
        return status;
    }

    public Visit setStatus(String status) {
        this.status = status;
        return this;
    }

    public Employe getEmploye() {
        return employe;
    }

    public Visit setEmploye(Employe employe) {
        this.employe = employe;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Visit setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public static Visit from(ResultSet rs, EmployeesEntity employeesEntity,CustomersEntity customersEntity) {
        Visit visit = new Visit();
        try {
            return visit.setId(rs.getInt("id"))
                    .setType(rs.getString("type"))
                    .setDateTime(rs.getString("date_time"))
                    .setResult(rs.getInt("result"))
                    .setActionCode(rs.getInt("action_code"))
                    .setCollectionStage(rs.getString("collection_stage"))
                    .setStatus(rs.getString("status"))
                    .setEmploye(employeesEntity.findById(rs.getInt("employe_id")))
                    .setCustomer(customersEntity.findById(rs.getInt("customer_id")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}

