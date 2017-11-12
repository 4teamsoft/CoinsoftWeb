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


    public List<Loan> findAll(CustomersEntity customersEntity) {
        return findByCriteria("", customersEntity);
    }



}
