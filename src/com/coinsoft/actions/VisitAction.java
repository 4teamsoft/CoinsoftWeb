package com.coinsoft.actions;

import com.coinsoft.models.Customer;
import com.coinsoft.models.User;
import com.opensymphony.xwork2.ActionSupport;

public class VisitAction extends ActionSupport{

    private String code;
    private String paymentDate;
    private double amount;
    private String status;
    private User user;
    private Customer customer;

    public VisitAction(String code, String paymentDate, double amount, String status, User user, Customer customer) {
        this.code = code;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.status = status;
        this.user = user;
        this.customer = customer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String execute() {
        return SUCCESS;
    }
}
