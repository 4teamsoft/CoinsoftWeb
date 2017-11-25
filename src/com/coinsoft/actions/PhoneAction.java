package com.coinsoft.actions;

import com.opensymphony.xwork2.ActionSupport;

public class PhoneAction extends ActionSupport{

    private String number;
    private String type;
    private String operator;

    public PhoneAction(String number, String type, String operator) {
        this.number = number;
        this.type = type;
        this.operator = operator;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String execute() {
        return SUCCESS;
    }
}
