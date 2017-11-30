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
    private SectorsEntity sectorsEntity;



    public CmDataStore(Connection connection) {
        this.connection = connection;
    }

    public CmDataStore() {
    }





    public int countUser(String user,String pwd) {
        if(connection == null) return 0;
        return getUsersEntity().countUser(user,pwd);
    }

    public User findUserWithLogin(String user,String pwd) {
        if(connection == null) return null;
          return getUsersEntity().findUserWithLogin(user,pwd);
    }

    public User findUserById(int id,EmployeesEntity employeesEntity ) {
        if(connection == null) return null;
        employeesEntity=getEmployeesEntity();
        return getUsersEntity().findById(id,employeesEntity);
    }

    public List<Sector> findByEmploye(int employe_id,EmployeesEntity employeesEntity,CustomersEntity customersEntity){
        if(connection == null) return null;
        employeesEntity=getEmployeesEntity();
        customersEntity=getCustomersEntity();
        return getSectorsEntity().findByEmploye(employe_id,employeesEntity,customersEntity);
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


    public Person findPersonById(int id) {
        if(connection == null) return null;
        return getPeopleEntity().findById(id);
    }


    public Customer findCustomerById(int id) {
        if(connection == null) return null;
        Person person = findPersonById(id);
        Customer customer=getCustomersEntity().findById(id);
        Customer customer1=new Customer(person.getId(),person.getCode(),person.getDni(),person.getName(),
                person.getLastName(),person.getAge(),person.getMail(),person.getStatus());
        return customer1;
    }

    public Employe findEmployeById(int id) {
        if(connection == null) return null;
        Person person = findPersonById(id);
        Employe employe=getEmployeesEntity().findById(id);
        Employe employe1=new Employe(person.getId(),person.getCode(),person.getDni(),person.getName(),
                person.getLastName(),person.getAge(),person.getMail(),person.getStatus(),employe.getStartDate(),employe.getEndDate());
        return employe1;
    }




    public int countCustomers() {
        if(connection == null) return 0;
        return getCustomersEntity().countCustomers();
    }



    public List<Customer> findAllCustomer() {

        return connection == null ? null : getCustomersEntity().findAll();
    }

    public List<Person> findAllPerson() {

        return connection == null ? null : getPeopleEntity().findAll();
    }

    public List<Employe> findAllEmployees() {

        return connection == null ? null : getEmployeesEntity().findAll();
    }




/*
    public Person createPerson(String code, String dni, String name, String lastName, int age, String mail, String status){
        return connection == null ?
                null :
                getPeopleEntity().create(code,dni,name,lastName,age,mail,status);
    }
*/


    public Customer createCustomer(int id, String code, String dni, String name, String lastName, int age, String mail, String status) {

        if (connection == null) return null;

        Person person = new Person(id,code,dni, name, lastName, age, mail,status);

        int personID = getPeopleEntity().create(person);

        return getCustomersEntity().create(personID,code,dni,name,lastName,age,mail,status);
    }

    public Employe createEmploye(int id, String code, String dni, String name, String lastName, int age, String mail, String status,String startDate,String endDate){

        if (connection == null) return null;

        Person person = new Person(id,code,dni, name, lastName, age, mail,status);

        int personID = getPeopleEntity().create(person);

        return getEmployeesEntity().create(personID,code,dni,name,lastName,age,mail,status,startDate,endDate);
    }



    public boolean updatePerson(int id,String code,String dni,String name, String lastName, int age,String mail, String status) {
        return connection == null ?
                false :
                getPeopleEntity().update(id,code,dni,name,lastName,age,mail,status);
    }

    public boolean updatePerson(Person person) {
        return updatePerson(person.getId(),person.getCode(),person.getDni(),person.getName(), person.getLastName(),
                person.getAge(), person.getMail(),person.getStatus());
    }


    public boolean updateCustomer(int id,String code,String dni,String name, String lastName, int age,String mail, String status) {
            if (connection == null) return false;
          boolean person=updatePerson(id,code,dni,name,lastName,age,mail,status);
          return   getCustomersEntity().update(id,code,dni,name,lastName,age,mail,status);
    }

    public boolean updateCustomer(Customer customer) {
        return updateCustomer(customer.getId(),customer.getCode(),customer.getDni(),customer.getName(), customer.getLastName(),
                customer.getAge(), customer.getMail(),customer.getStatus());
    }

    public boolean updateEmploye(int id,String code,String dni,String name, String lastName, int age,String mail, String status,String startDate,String endDate) {
        if (connection == null) return false;
        boolean person=updatePerson(id,code,dni,name,lastName,age,mail,status);
        return   getEmployeesEntity().update(id,code,dni,name,lastName,age,mail,status,startDate,endDate);
    }

    public boolean updateEmploye(Employe employe) {
        return updateEmploye(employe.getId(),employe.getCode(),employe.getDni(),employe.getName(), employe.getLastName(),
                employe.getAge(), employe.getMail(),employe.getStatus(),employe.getStartDate(),employe.getEndDate());
    }

    public boolean eraseEmploye(int id) {
        return connection == null ?
                false :
                getEmployeesEntity().erase(id);
    }

    public boolean eraseCustomer(int id) {
        return connection == null ?
                false :
                getCustomersEntity().erase(id);
    }

    private SectorsEntity getSectorsEntity() {
        if(sectorsEntity == null) {
            sectorsEntity = new SectorsEntity();
            sectorsEntity.setConnection(connection);
        }
        return sectorsEntity;
    }


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



}