package com.coinsoft.models;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuditTrail {
    private int id;
    private String type;
    private Date dateTime;
    private String affectedTable;
    private String detail;
    private String status;

    public AuditTrail(int id, String type, Date dateTime, String affectedTable, String detail, String status) {
        this.id = id;
        this.type = type;
        this.dateTime = dateTime;
        this.affectedTable = affectedTable;
        this.detail = detail;
        this.status = status;
    }

    public AuditTrail() {
    }


    public String getType() {
        return type;
    }

    public AuditTrail setType(String type) {
        this.type = type;
        return this;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public AuditTrail setDateTime(Date dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public String getAffectedTable() {
        return affectedTable;
    }

    public AuditTrail setAffectedTable(String affectedTable) {
        this.affectedTable = affectedTable;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public AuditTrail setDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public AuditTrail setStatus(String status) {
        this.status = status;
        return this;
    }

    public int getId() {
        return id;
    }

    public AuditTrail setId(int id) {
        this.id = id;
        return this;
    }

    public static AuditTrail from(ResultSet rs) {
        try {
            return new AuditTrail(
                    rs.getInt("audit_trails_id"),
                    rs.getString("type"),
                    rs.getDate("date_time"),
                    rs.getString("affected_table"),
                    rs.getString("detail"),
                    rs.getString("status"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
