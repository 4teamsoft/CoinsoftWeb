package com.coinsoft.actions;

import com.coinsoft.models.Customer;
import com.coinsoft.models.Employe;
import com.opensymphony.xwork2.ActionSupport;

public class SectorAction extends ActionSupport {
    private int id;
    private String name;
    private String detail;
    private String status;
    private Employe employe;
    private Customer customer;

    public SectorAction() {
    }

    public SectorAction(int id, String name, String detail, String status, Employe employe, Customer customer) {
        this.setId(id);
        this.setName(name);
        this.setDetail(detail);
        this.setStatus(status);
        this.setEmploye(employe);
        this.setCustomer(customer);
    }

    public int getId() {
        return id;
    }

    public SectorAction setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
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
