package com.coinsoft.actions;

import com.coinsoft.models.Customer;

import com.opensymphony.xwork2.ActionSupport;

public class VisitAction extends ActionSupport{

    private String paymentDate;
    private double amount;
    private Customer customer;

    public VisitAction(String paymentDate, double amount, Customer customer) {

        this.paymentDate = paymentDate;
        this.amount = amount;

        this.customer = customer;
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
