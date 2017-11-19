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

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM loans";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            return resultSet.next() ? resultSet.getInt("max_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Loan create(Loan loan) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id, code_loan, date_start, amount, number_quota, day, type, status, customer_id) " +
                        "VALUES(%d,%d,'%s',%f,%d,%d,'%s','%s',%d)",
                getTableName(),loan.getId(), loan.getCodeLoan(), loan.getDateStart(),loan.getAmount(),loan.getNumberQuota(),
                loan.getDay(),loan.getType(),loan.getStatus(),loan.getCustomer().getId()))? loan : null;
    }

    public Loan create(int codeLoan, String dateStart, double amount, int numberQuota, int day, String type, String status, Customer customer) {
        return create(new Loan(getMaxId() + 1, codeLoan, dateStart, amount, numberQuota, day, type, status, customer));
    }

    public Loan create(int id, int codeLoan, String dateStart, double amount, int numberQuota, int day, String type, String status, Customer customer) {
        return create(new Loan(id, codeLoan, dateStart, amount, numberQuota, day, type, status, customer));
    }


    public boolean update(int id, int codeLoan, String dateStart, double amount, int numberQuota, int day, String type, String status, Customer customer) {
        return executeUpdate(String.format(
                "UPDATE %s SET code_loan = '%s',date_start = '%s',amount = %f, number_quota = %d, day = %d, " +
                        "type = '%s',status = '%s',customer_id = %d WHERE id = %d",
                getTableName(), codeLoan, dateStart, amount, numberQuota, day, type, status, customer.getId(),id));
    }

    public boolean update(Loan loan) {
        return update(loan.getId(), loan.getCodeLoan(),loan.getDateStart(),loan.getAmount(),loan.getNumberQuota(),loan.getDay(),
                loan.getType(),loan.getStatus(),loan.getCustomer());
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
