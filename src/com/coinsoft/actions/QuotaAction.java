package com.coinsoft.actions;

import com.opensymphony.xwork2.ActionSupport;

public class QuotaAction extends ActionSupport{
    private String code;
    private String paymentDate;
    private String type;
    private double amount;
    private String status;

    public QuotaAction(String code, String paymentDate, String type, double amount, String status) {
        this.code = code;
        this.paymentDate = paymentDate;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public void  setStatus(String status) {
        this.status = status;
    }
//DDD
    public String execute(){
        return SUCCESS;

    }

}
