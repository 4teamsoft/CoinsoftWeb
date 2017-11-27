package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Loan {

        private int id;
        private String code;
        private String startDate;
        private double amount;
        private int numberQuota;
        private int day;
        private String type;
        private String status;
        private Customer customer;

        public Loan() {
        }

        public Loan(int id, String code, String startDate, double amount, int numberQuota, int day, String type, String status, Customer customer) {
            this.id = id;
            this.code = code;
            this.startDate = startDate;
            this.amount = amount;
            this.numberQuota = numberQuota;
            this.day = day;
            this.type = type;
            this.status = status;
            this.customer = customer;
        }


    public int getId() {
        return id;
    }

    public Loan setId(int id) {
        this.id = id;return this;
    }

    public String getCode() {
        return code;
    }

    public Loan setCode(String code) {
        this.code = code;return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public Loan setStartDate(String startDate) {
        this.startDate = startDate;return this;
    }

    public double getAmount() {
        return amount;
    }

    public Loan setAmount(double amount) {
        this.amount = amount;return this;
    }

    public int getNumberQuota() {
        return numberQuota;
    }

    public Loan setNumberQuota(int numberQuota) {
        this.numberQuota = numberQuota;return this;
    }

    public int getDay() {
        return day;
    }

    public Loan setDay(int day) {
        this.day = day;return this;
    }

    public String getType() {
        return type;
    }

    public Loan setType(String type) {
        this.type = type;return this;
    }

    public String getStatus() {
        return status;
    }

    public Loan setStatus(String status) {
        this.status = status;return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Loan setCustomer(Customer customer) {
        this.customer = customer; return this;
    }





    public static Loan from(ResultSet rs, CustomersEntity customersEntity) {
        Loan loan = new Loan();
        try {
            return loan.setId(rs.getInt	("loan_id"))
                    .setCode(rs.getString("code"))
                    .setStartDate(rs.getString("start_date"))
                    .setAmount(rs.getDouble("amount"))
                    .setNumberQuota(rs.getInt("number_quota"))
                    .setDay(rs.getInt("day"))
                    .setType(rs.getString("type"))
                    .setStatus(rs.getString("status"))
                    .setCustomer(customersEntity.findById(rs.getInt("customer_id")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
