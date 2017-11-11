package com.coinsoft.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssignmentsEntity extends BaseEntity{

    public  AssignmentsEntity(){
        super();
        setTableName("assignments");

    }

    public AssignmentsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public List<Assignment> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<Assignment> assignments = new ArrayList<>();
            while (rs.next())
                assignments.add(Assignment.from(rs));

            return assignments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Assignment> findAll() {
        return findByCriteria("");
    }

    public Assignment findById(int id) {
        return findByCriteria(
                String.format("WHERE id = '%d'", id)).get(0);
    }

    public Assignment create(Assignment assignment) {
        return executeUpdate(String.format("INSERT INTO %s(id,assigned_from,assigned_to, detail, status) VALUES(%d,'%s','%s', '%s', '%s')", getTableName(), assignment.getId(), assignment.getAssignedFrom(), assignment.getAssignedTo(), assignment.getDetail(), assignment.getStatus())) ? assignment:null;

    }


}
