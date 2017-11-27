package com.coinsoft.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstallmentsEntity extends BaseEntity{

    public InstallmentsEntity(){
        super();
        setTableName("installments");

    }

    public Quota findById(int id, LoansEntity loansEntity,CustomersEntity customersEntity) {
        return findByCriteria(
                String.format("WHERE id = %d", id), loansEntity,customersEntity).get(0);
    }

    public List<Quota> findByCriteria(String criteria, LoansEntity loansEntity, CustomersEntity customersEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Quota> installments = new ArrayList<>();
            while(rs.next())
                installments.add(Quota.from(rs, loansEntity,customersEntity));

            return installments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM installments";
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



    public List<Quota> findAll(LoansEntity loansEntity,CustomersEntity customersEntity) {
        return findByCriteria("",loansEntity,customersEntity);
    }

    public boolean create(Quota quota) {
        int id = getMaxId() + 1;
        return executeUpdate(String.format("INSERT INTO %s(id, code, payment_date,amount,status,loan_id) " +
                        "VALUES(%d,'%s',%s,%f,'1',%d )",getTableName(), id,quota.getCode(),quota.getPaymentDate(),
                        quota.getAmount(),quota.getLoan().getId()));
    }


    public boolean update(int id, String code,String paymentDate,double amount,String status,Loan loan) {
        return executeUpdate(String.format(
                "UPDATE %s SET code = '%s',payment_date = %s,amount = %f,status = '1',loan_id = %d WHERE id = %d",
                getTableName(), code, paymentDate, amount,loan.getId(),id));
    }

    public boolean update(Quota quota) {
        return update(quota.getId(), quota.getCode(),quota.getPaymentDate(),quota.getAmount(),
                quota.getStatus(),quota.getLoan());
    }


    public boolean erase(int id) {
        return executeUpdate(String.format("UPDATE %s SET status = '0' WHERE id = %d ",
                getTableName(), id));
    }
    public boolean erase(Quota quota) {
        return executeUpdate(String.format("UPDATE %s SET status = '0' WHERE id = %d",
                getTableName(), quota.getId()));
    }




}
