package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Quota {
    private int id;
    private String code;
    private String paymentDate;
    private double amount;
    private String status;
    private Loan loan;

    public Quota() {
    }

    public Quota(int id, String code, String paymentDate, double amount, String status, Loan loan) {
        this.id = id;
        this.code = code;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.status = status;
        this.loan = loan;
    }

    public int getId() {
        return id;
    }

    public Quota setId(int id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Quota setCode(String code) {
        this.code = code;
        return this;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public Quota setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public Quota setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Quota setStatus(String status) {
        this.status = status;
        return this;
    }

    public Loan getLoan() {
        return loan;
    }

    public Quota setLoan(Loan loan) {
        this.loan = loan;
        return this;
    }
    public static Quota from(ResultSet rs, LoansEntity loansEntity) {
        Quota quota = new Quota();
        try {
            return quota.setId(rs.getInt("id"))
                    .setCode(rs.getString("code"))
                    .setPaymentDate(rs.getString("payment_Date"))
                    .setAmount(rs.getDouble("amount"))
                    .setStatus(rs.getString("status"))
                    .setLoan(loansEntity.findById(rs.getInt("loan_id")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}