package com.coinsoft.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuditTrailsEntity extends BaseEntity {


    public AuditTrailsEntity() {
        super();
        setTableName("audit_trails");
    }

    public AuditTrailsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public List<AuditTrail> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<AuditTrail> auditTrails = new ArrayList<>();
            while (rs.next())
                auditTrails.add(AuditTrail.from(rs));

            return auditTrails;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public AuditTrail findById(int id) {
        return findByCriteria(
                String.format("WHERE id = '%d' AND status= '%s'", id,"1")).get(0);
    }

    public List<AuditTrail> findByType(String type) {
        return findByCriteria(
                String.format("WHERE type = '%s' AND status= '%s'", type,"1"));
    }

    public List<AuditTrail> findAll() {
        return findByCriteria(String.format("WHERE status = '%s'", "1"));
    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM audit_trails";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            return resultSet.next() ? resultSet.getInt("max_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public AuditTrail create(AuditTrail auditTrail) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id,type, date_time, affected_table, detail , status ) " +
                        "VALUES(%d,'%s','%s', '%s', '%s','%s')",
                getTableName(), auditTrail.getId(), auditTrail.getType(), auditTrail.getDateTime(), auditTrail.getAffectedTable(),
                auditTrail.getDetail(), auditTrail.getStatus()
        )) ? auditTrail : null;
    }

    public AuditTrail create(String type,Date dateTime,String affectedTable, String detail, String status) {
        return create(new AuditTrail(getMaxId() + 1, type, dateTime, affectedTable, detail, status));
    }

    public AuditTrail create(int id, String type, Date dateTime, String affectedTable,String detail, String status) {
        return create(new AuditTrail(id,type,dateTime, affectedTable, detail,status));
    }


    public boolean update(int id, String type, Date dateTime,String affectedTable,String detail,String status) {
        return executeUpdate(String.format(
                "UPDATE %s SET type = '%s',date_time = '%s',affected_table = '%s', detail='%s',  status='%s' WHERE id = %d",
                getTableName(),type,dateTime, affectedTable, detail, status, id));
    }

    public boolean update(AuditTrail auditTrail) {
        return update(auditTrail.getId(),auditTrail.getType(),auditTrail.getDateTime(),auditTrail.getAffectedTable(),
                auditTrail.getDetail(), auditTrail.getStatus());
    }

    /*  int id;  String type; Date dateTime; String affectedTable; String detail; String status; */
    public boolean erase(int id) {
        return executeUpdate(String.format("UPDATE %s SET status='%s' WHERE id = %d",
                getTableName(),"0", id));
    }


    public boolean erase(AuditTrail auditTrail) {
        return executeUpdate(String.format("UPDATE %s SET status='%s' WHERE id = %d",
                getTableName(),"0", auditTrail.getId()));

    }



}
