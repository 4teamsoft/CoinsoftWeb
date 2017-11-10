package com.coinsoft.models;

public class Role {
    private int id;
    private String name;
    private String status;

    public Role() {
    }

    public Role(int id,String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Role setStatus(String status) {
        this.status = status;
        return this;
    }

    public int getId() {
        return id;
    }

    public Role setId(int id) {
        this.id = id;
        return this;
    }
}
