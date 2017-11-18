package com.coinsoft.actions;

import com.opensymphony.xwork2.ActionSupport;


public class CustomerAction extends ActionSupport{


    private String type;
    private String status;

    public CustomerAction(String type, String status) {
        this.type = type;
        this.status = status;
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
