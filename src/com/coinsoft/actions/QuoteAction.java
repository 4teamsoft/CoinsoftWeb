package com.coinsoft.actions;


import com.opensymphony.xwork2.ActionSupport;

public class QuoteAction extends ActionSupport {

    private String code;
    private String paymentDate;
    private double amount;
    private String status;


    public QuoteAction(String code, String paymentDate, double amount, String status) {
        this.code = code;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.status = status;
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

    public String  execute(){
        return SUCCESS;
    }

}
