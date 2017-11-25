package com.coinsoft.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VisitsEntity extends BaseEntity{

    public VisitsEntity(){
        super();
        setTableName("visits");

    }

    public Visit findById(int id, EmployeesEntity employeesEntity,CustomersEntity customersEntity) {
        return findByCriteria(
                String.format("WHERE id = %d", id),employeesEntity,customersEntity).get(0);
    }

    public List<Visit> findByCriteria(String criteria,EmployeesEntity employeesEntity,CustomersEntity customersEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Visit> visits = new ArrayList<>();
            while(rs.next())
                visits.add(Visit.from(rs,employeesEntity,customersEntity));

            return visits;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List<Visit> findAll(EmployeesEntity employeesEntity,CustomersEntity customersEntity) {
        return findByCriteria("",employeesEntity,customersEntity);
    }


}
