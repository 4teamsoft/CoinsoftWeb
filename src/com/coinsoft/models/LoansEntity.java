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

    public LoansEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public List<Loan> findByCriteria(String criteria, LoansEntity customersEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<Loan> loans = new ArrayList<>();
            while (rs.next())
                //loans.add(Loan.from(rs,customersEntity));

            return loans;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    //public List<Loan> findAll(CustomersEntity customersEntity)
    //{
      //  return findByCriteria("",customersEntity);
   // }


   /* public Loan create(Loan loan) {
        return executeUpdate(String.format
                ("INSERT INTO %s(id,assigned_from,assigned_to, detail, status) VALUES(%d,'%s','%s', '%s', '%s')", getTableName(), assignment.getId(), assignment.getAssignedFrom(), assignment.getAssignedTo(), assignment.getDetail(), assignment.getStatus())) ? assignment:null;

    }
    */

    public Loan findById(int id, LoansEntity customersEntity) {

        return findByCriteria(String.format("WHERE id = '%d'", id),customersEntity).get(0);

    }



}
