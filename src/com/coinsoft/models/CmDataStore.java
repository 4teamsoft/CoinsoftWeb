package com.coinsoft.models;

import java.sql.Connection;
import java.util.List;

public class CmDataStore {

    private Connection connection;

    private CustomersEntity customersEntity;
    private EmployeesEntity employeesEntity;
    private LoansEntity loansEntity;
    private PeopleEntity peopleEntity;
    private UsersEntity usersEntity;
    private VisitsEntity visitsEntity;



    public CmDataStore(Connection connection) {
        this.connection = connection;
    }

    public CmDataStore() {
    }

    public Customer findCustomerById(int id) {
        if(connection == null) return null;
        return getCustomersEntity().findById(id);
    }

    public int countCustomers() {
        if(connection == null) return 0;
        return getCustomersEntity().countCustomers();
    }

    public int countUser(String user,String pwd) {
        if(connection == null) return 0;
        return getUsersEntity().countUser(user,pwd);
    }

    public User findUserWithLogin(String user,String pwd,EmployeesEntity employeesEntity ) {
        if(connection == null) return null;
        return getUsersEntity().findUserWithLogin(user,pwd,employeesEntity);
    }

/*
    public Employe findEmployeById(int id) {
        if(connection == null) return null;
        return getEmployeesEntity().findById(id);
    }*/

    public Loan findLoanById(int id) {
        if(connection == null) return null;
        return getLoansEntity().findById(id, getCustomersEntity());
    }
/*
    public User findUserById(int id) {
        if(connection == null) return null;
        return getUsersEntity().findById(id, getEmployeesEntity());
    }*/
/*
    public Visit findVisitById(int id) {
        if(connection == null) return null;
        return getVisitsEntity().findById(id,getUsersEntity(),getCustomersEntity());
    }*/
/*
    public List<Assignment> findAllAssignment() {
        return connection == null ? null: getAssignmentsEntity().findAll();
    }*/


    /*
        public List<Employe> findAllEmploye() {
            return connection == null ? null: getEmployeesEntity().findAll();
        }
    */
    public List<Loan> findAllLoan() {

        return connection == null ? null : getLoansEntity().findAll(getCustomersEntity());
    }
/*
    public List<User> findAllUser() {
        return connection == null ? null: getUsersEntity().findAll(getEmployeesEntity());
    }*/
/*
    public List<Visit> findAllVisit() {
        return connection == null ? null : getVisitsEntity().findAll(getUsersEntity(),getCustomersEntity());
    }*/

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /*private AssignmentsEntity getAssignmentsEntity() {
        if(assignmentsEntity == null) {
            assignmentsEntity = new AssignmentsEntity();
            assignmentsEntity.setConnection(connection);
        }
        return assignmentsEntity;
    }*/

    public List<Customer> findAllCustomer() {

        return connection == null ? null : getCustomersEntity().findAll();
    }


    public Person createPerson(String code, String dni, String name, String lastName, int age, String mail, String status){
        return connection == null ?
                null :
                getPeopleEntity().create(code,dni,name,lastName,age,mail,status);
    }



    public Customer createCustomer(int id, String code, String dni, String name, String lastName, int age,
                                     String mail, String status) {

        if (connection == null) return null;
        //PeopleEntity peopleEntity=new PeopleEntity();
        Person person=createPerson(code,dni,name,lastName,age,mail,status);
        //Person person=getPeopleEntity().create(code,dni,name,lastName,age,mail,status);
        return getCustomersEntity().create(person.getId(),code,dni,name,lastName,age,mail,status/*,peopleEntity*/);
    }

/*
public List<Customer> findAllCustomers() {
        return dataStore.findAllCustomer();
    }



    public Customer createCustomer(int id, String code, String dni, String name, String lastName, int age,
                                     String mail, String status) {
        return dataStore.createCustomer(id,code,dni,name,lastName,age,mail,status);
    }
 */





    private CustomersEntity getCustomersEntity() {
        if(customersEntity == null) {
            customersEntity = new CustomersEntity();
            customersEntity.setConnection(connection);
        }
        return customersEntity;
    }

    private PeopleEntity getPeopleEntity(){
        if(peopleEntity == null){
            peopleEntity = new PeopleEntity();
            peopleEntity.setConnection(connection);
        }
        return peopleEntity;
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

    private UsersEntity getUsersEntity() {
            if(usersEntity == null) {
                usersEntity = new UsersEntity();
                usersEntity.setConnection(connection);
            }
            return usersEntity;
    }

    private VisitsEntity getVisitsEntity() {
        if(visitsEntity == null) {
            visitsEntity = new VisitsEntity();
            visitsEntity.setConnection(connection);
        }
        return visitsEntity;
    }




    /*public Customer createCustomer(String code, String dni, String name, String lastName, int age, String mail, String type,String status) {
        return connection == null ?
                null :
                getCustomersEntity().create(code,dni,name,lastName,age,mail,type,status);
    }*/


    /*
    public Customer createCustomer(String code, String dni, String name, String lastName, int age, String mail) {
        if(connection == null)return null;
        Person person = getPeopleEntity().create(code,dni,name,lastName,age,mail);
        return getCustomersEntity().create(person);
    }


*/









}