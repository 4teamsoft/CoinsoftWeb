package com.coinsoft.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoansEntity extends BaseEntity{

    public LoansEntity(){
        super();
        setTableName("loans");

    }

    public Loan findById(int id, CustomersEntity customersEntity) {
        return findByCriteria(
                String.format("WHERE id = %d", id), customersEntity).get(0);
    }

    public List<Loan> findByCriteria(String criteria, CustomersEntity customersEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Loan> loans = new ArrayList<>();
            while(rs.next())
                loans.add(Loan.from(rs, customersEntity));

            return loans;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM loans";
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



    public List<Loan> findAll(CustomersEntity customersEntity) {
        return findByCriteria("", customersEntity);
    }

    public boolean create(Loan loan) {
        int id = getMaxId() + 1;
        return executeUpdate(String.format("INSERT INTO %s(id, code, start_date,amount,number_quota,day,type,status,customer_id) " +
                        "VALUES(%d,'%s',%s,%f,%d,%d,'%s','1',%d )",getTableName(), id,loan.getCode(),loan.getStartDate(),
                        loan.getAmount(),loan.getNumberQuota(),loan.getDay(),loan.getType(),loan.getCustomer().getId()));
    }


    public boolean update(int id, String code,String startDate,double amount,int numberQuota,int day,String type,String status,Customer customer) {
        return executeUpdate(String.format(
                "UPDATE %s SET code = '%s',start_date = %s,amount = %f,number_quota = %d, day = %d, type = '%s'," +
                        "status = '1',customer_id = %d WHERE id = %d", getTableName(), code, startDate, amount,
                        numberQuota,day,type,customer.getId(),id));
    }

    public boolean update(Loan loan) {
        return update(loan.getId(), loan.getCode(),loan.getStartDate(),loan.getAmount(),loan.getNumberQuota(),loan.getDay(),
                loan.getType(), loan.getStatus(),loan.getCustomer());
    }


    public boolean erase(int id) {
        return executeUpdate(String.format("UPDATE %s SET status = '0' WHERE id = %d ",
                getTableName(), id));
    }
    public boolean erase(Loan loan) {
        return executeUpdate(String.format("UPDATE %s SET status = '0' WHERE id = %d",
                getTableName(), loan.getId()));
    }




}
