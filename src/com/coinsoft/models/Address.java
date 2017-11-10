package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Address {
    private int id;
    private String department;
    private String province;
    private String district;
    private String via;
    private String nameVia;
    private String numberDoor;
    private String numberDepartment;
    private String block;
    private String allotment;
    private String reference;
    private String status;
    private Customer customer;

    public Address() {
    }

    public Address(int id, String department, String province, String district, String via, String nameVia, String numberDoor,
                   String numberDepartment, String block, String allotment, String reference, String status, Customer customer) {
        this.id = id;
        this.department = department;
        this.province = province;
        this.district = district;
        this.via = via;
        this.nameVia = nameVia;
        this.numberDoor = numberDoor;
        this.numberDepartment = numberDepartment;
        this.block = block;
        this.allotment = allotment;
        this.reference = reference;
        this.status = status;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Address setId(int id) {
        this.id = id;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public Address setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getProvince() {
        return province;
    }

    public Address setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getDistrict() {
        return district;
    }

    public Address setDistrict(String district) {
        this.district = district;
        return this;
    }

    public String getVia() {
        return via;
    }

    public Address setVia(String via) {
        this.via = via;
        return this;
    }

    public String getNameVia() {
        return nameVia;
    }

    public Address setNameVia(String nameVia) {
        this.nameVia = nameVia;
        return this;
    }

    public String getNumberDoor() {
        return numberDoor;
    }

    public Address setNumberDoor(String numberDoor) {
        this.numberDoor = numberDoor;
        return this;
    }

    public String getNumberDepartment() {
        return numberDepartment;
    }

    public Address setNumberDepartment(String numberDepartment) {
        this.numberDepartment = numberDepartment;
        return this;
    }

    public String getBlock() {
        return block;
    }

    public Address setBlock(String block) {
        this.block = block;
        return this;
    }

    public String getAllotment() {
        return allotment;
    }

    public Address setAllotment(String allotment) {
        this.allotment = allotment;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public Address setReference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Address setStatus(String status) {
        this.status = status;
        return this;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Address setCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }
    public static Address from(ResultSet rs, CustomersEntity customersEntity) {
        Address address = new Address();
        try {
            return address.setId(rs.getInt("address_id"))
                    .setDepartment(rs.getString("department"))
                    .setProvince(rs.getString("province"))
                    .setDistrict(rs.getString("district"))
                    .setVia(rs.getString("via"))
                    .setNameVia(rs.getString("name_via"))
                    .setNumberDoor(rs.getString("number_door"))
                    .setNumberDepartment(rs.getString("number_department"))
                    .setBlock(rs.getString("block"))
                    .setAllotment(rs.getString("allotment"))
                    .setReference(rs.getString("reference"))
                    .setStatus(rs.getString("status"))
                    .setCustomer(customersEntity.findById(rs.getInt("customer_id")));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

//creditos a kevin que no trajo laptop :v
