package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Assignment {
    private int id;
    private Date assignedFrom;
    private Date assignedTo;
    private String detail;
    private String status;
    private Employe employe;
    private Employe manager;

    public Assignment() {
    }

    public Assignment(int id, Date assignedFrom, Date assignedTo, String detail, String status, Employe employe, Employe manager) {
        this.id = id;
        this.assignedFrom = assignedFrom;
        this.assignedTo = assignedTo;
        this.detail = detail;
        this.status = status;
        this.employe = employe;
        this.manager = manager;
    }

    public int getId() {
        return id;
    }

    public Assignment setId(int id) {
        this.id = id;
        return this;
    }

    public Date getAssignedFrom() {
        return assignedFrom;
    }

    public Assignment setAssignedFrom(Date assignedFrom) {
        this.assignedFrom = assignedFrom;
        return this;
    }

    public Date getAssignedTo() {
        return assignedTo;
    }

    public Assignment setAssignedTo(Date assignedTo) {
        this.assignedTo = assignedTo;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public Assignment setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Assignment setStatus(String status) {
        this.status = status;
        return this;
    }

    public Employe getEmploye() {
        return employe;
    }

    public Assignment setEmploye(Employe employe) {
        this.employe = employe;
        return this;
    }

    public Employe getManager() {
        return manager;
    }

    public Assignment setManager(Employe manager) {
        this.manager = manager;
        return this;
    }



    public static Assignment from(ResultSet rs) {
        Assignment assignment=new Assignment();
                try {
            return assignment.setId(rs.getInt("id")).setAssignedFrom(rs.getDate("assigned_from")).setAssignedTo(rs.getDate("assigned_to"))
                    .setDetail(rs.getString("detail"))
                    .setStatus(rs.getString("status"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}



