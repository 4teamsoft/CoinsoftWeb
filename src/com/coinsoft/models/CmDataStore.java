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

    /*public Loan findLoanById(int id) {
        if(connection == null) return null;
        return getLoansEntity().findById(id);
    }

    public Visit findVisitById(int id) {
        if(connection == null) return null;
        return getVisitsEntity().findById(id);
    }*/

    public List<Assignment> findAllAssignment() {

        return connection == null ? null: getAssignmentsEntity().findAll();
    }

    public List<Customer> findAllCustomer() {

        return connection == null ? null : getCustomersEntity().findAll();
    }

    public List<Employe> findAllEmploye() {

        return connection == null ? null: getEmployeesEntity().findAll();
    }

    /*public List<Loan> findAllLoan() {

        return connection == null ? null : getLoansEntity().findAll();
    }

    public List<Visit> findAllVisit() {

        return connection == null ? null : getVisitsEntity().findAll();
    }*/

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    private AssignmentsEntity getAssignmentsEntity() {
        if(assignmentsEntity == null) {
            assignmentsEntity = new AssignmentsEntity();
            assignmentsEntity.setConnection(connection);
        }
        return assignmentsEntity;
    }

    private CustomersEntity getCustomersEntity() {
        if(customersEntity == null) {
            customersEntity = new CustomersEntity();
            customersEntity.setConnection(connection);
        }
        return customersEntity;
    }

    private EmployeesEntity getEmployeesEntity() {
        if(employeesEntity == null) {
            employeesEntity = new EmployeesEntity();
            employeesEntity.setConnection(connection);
        }
        return employeesEntity;
    }

    private LoansEntity getLoansEntity() {
        if(loansEntity == null) {
            loansEntity = new LoansEntity();
            loansEntity.setConnection(connection);
        }
        return loansEntity;
    }

    /*private VisitsEntity getVisitsEntity() {
        if(visitsEntity == null) {
            visitsEntity = new VisitsEntity();
            visitsEntity.setConnection(connection);
        }
        return visitsEntity;
    }*/
}
