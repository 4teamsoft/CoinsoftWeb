package com.coinsoft.models;

import java.sql.Connection;
import java.util.List;

public class CmDataStore {

    private Connection connection;
    private AssignmentsEntity assignmentsEntity;
    private CustomersEntity customersEntity;
    private EmployeesEntity employeesEntity;
    private LoansEntity loansEntity;
    private VisitsEntity visitsEntity;

    public CmDataStore(Connection connection) {
        this.connection = connection;
    }

    public CmDataStore() {
    }

    public Assignment findAssignmentById(int id) {
        if(connection == null) return null;
        return getAssignmentsEntity().findById(id);
    }

    public Customer findCustomerById(int id) {
        if(connection == null) return null;
        return getCustomersEntity().findById(id);
    }

    public Employe findEmployeById(int id) {
        if(connection == null) return null;
        return getEmployeesEntity().findById(id);
    }

    public Loan findLoanById(String id) {
        if(connection == null) return null;
        return getLoansEntity().findById(id);
    }

}
