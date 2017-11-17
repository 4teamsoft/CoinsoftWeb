package com.coinsoft.actions;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
    private String username;
    private String password;

    public UserAction(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String execute() {
        return SUCCESS;
    }

}