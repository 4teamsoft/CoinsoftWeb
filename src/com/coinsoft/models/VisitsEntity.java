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

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM visits";
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            return resultSet.next() ?
                    resultSet.getInt("max_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public List<Visit> findAll(EmployeesEntity employeesEntity,CustomersEntity customersEntity) {
        return findByCriteria("",employeesEntity,customersEntity);
    }


    public Visit create(Visit visit) {

        int id = getMaxId() + 1;
        return executeUpdate(String.format("INSERT INTO %s(id,type,date_time,result,action_code,collection_stage,status,employe_id,customer_id) " +
                        "VALUES(%d,'%s','%s',%d,%d,'%s','%s',%d,%d)",
                getTableName(), id, visit.getType(), visit.getDateTime(),visit.getResult(), visit.getActionCode(),
                visit.getCollectionStage(),'1',visit.getEmploye().getId(),visit.getCustomer().getId() ))? visit:null;

    }





}
