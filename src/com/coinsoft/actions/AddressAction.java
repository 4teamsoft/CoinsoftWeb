package com.coinsoft.actions;

import com.opensymphony.xwork2.ActionSupport;


public class AddressAction extends ActionSupport{

    private String department;
    private String province;
    private String district;
    private String nameStreet;
    private String numberDoor;
    private String numberDepartment;
    private String block;
    private String allotment;
    private String reference;
    private String status;

    public AddressAction(String department, String province, String district, String nameStreet, String numberDoor, String numberDepartment, String block, String allotment, String reference, String status) {
        this.department = department;
        this.province = province;
        this.district = district;
        this.nameStreet = nameStreet;
        this.numberDoor = numberDoor;
        this.numberDepartment = numberDepartment;
        this.block = block;
        this.allotment = allotment;
        this.reference = reference;
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getNameStreet() {
        return nameStreet;
    }

    public void setNameStreet(String nameStreet) {
        this.nameStreet = nameStreet;
    }

    public String getNumberDoor() {
        return numberDoor;
    }

    public void setNumberDoor(String numberDoor) {
        this.numberDoor = numberDoor;
    }

    public String getNumberDepartment() {
        return numberDepartment;
    }

    public void setNumberDepartment(String numberDepartment) {
        this.numberDepartment = numberDepartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getAllotment() {
        return allotment;
    }

    public void setAllotment(String allotment) {
        this.allotment = allotment;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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
