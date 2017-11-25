package com.coinsoft.actions;

import com.opensymphony.xwork2.ActionSupport;

public class LoanAction extends  ActionSupport {

    private int codeLoan;
    private String dateStart;
    private double amount;

    private int numberQuota;
    private int day;
    private String type;
    private String status;


    public LoanAction(int codeLoan, String dateStart, double amount, int numberQuota, int day, String type, String status) {
        this.codeLoan = codeLoan;
        this.dateStart = dateStart;
        this.amount = amount;
        this.numberQuota = numberQuota;
        this.day = day;
        this.type = type;
        this.status = status;
    }

    public int getCodeLoan() {
        return codeLoan;
    }

    public void setCodeLoan(int codeLoan) {
        this.codeLoan = codeLoan;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNumberQuota() {
        return numberQuota;
    }

    public void setNumberQuota(int numberQuota) {
        this.numberQuota = numberQuota;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String execute() {
        return SUCCESS;
    }
}
