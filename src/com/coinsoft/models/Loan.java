package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Loan {

        private int id;
        private int codeLoan;
        private String dateStart;
        private double amount;
        private int numberQuota;
        private int day;
        private String type;
        private String status;
        private Customer customer;

        public Loan() {
        }

        public Loan(int id, int codeLoan, String dateStart, double amount, int numberQuota, int day, String type, String status, Customer customer) {
            this.id = id;
            this.codeLoan = codeLoan;
            this.dateStart = dateStart;
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

        public com.coinsoft.models.Loan setId(int id) {
            this.id = id;
            return this;
        }

        public int getCodeLoan() {
            return codeLoan;
        }

        public com.coinsoft.models.Loan setCodeLoan(int codeLoan) {
            this.codeLoan = codeLoan;
            return this;
        }

        public String getDateStart() {
            return dateStart;
        }

        public com.coinsoft.models.Loan setDateStart(String dateStart) {
            this.dateStart = dateStart;
            return this;
        }

        public double getAmount() {
            return amount;
        }

        public com.coinsoft.models.Loan setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public int getNumberQuota() {
            return numberQuota;
        }

        public com.coinsoft.models.Loan setNumberQuota(int numberQuota) {
            this.numberQuota = numberQuota;
            return this;
        }

        public int getDay() {
            return day;
        }

        public com.coinsoft.models.Loan setDay(int day) {
            this.day = day;
            return this;
        }

        public String getType() {
            return type;
        }

        public com.coinsoft.models.Loan setType(String type) {
            this.type = type;
            return this;
        }

        public String getStatus() {
            return status;
        }

        public com.coinsoft.models.Loan setStatus(String status) {
            this.status = status;
            return this;
        }

        public Customer getCustomer() {
            return customer;
        }

        public com.coinsoft.models.Loan setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

    public static Loan from(ResultSet rs, CustomersEntity customersEntity) {
        Loan loan = new Loan();
        try {
            return loan.setId(rs.getInt	("id"))
                    .setCodeLoan(rs.getInt("code"))
                    .setDateStart(rs.getString("start_date"))
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
