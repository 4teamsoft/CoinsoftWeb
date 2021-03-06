package com.coinsoft.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CmService {

    private Connection connection;
    private CmDataStore dataStore;

    public CmService() {
        try {
            InitialContext context = new InitialContext();
            dataStore = new CmDataStore();
            connection = ((DataSource) context
                    .lookup("jdbc/MySQLDataSourceCm"))
                    .getConnection();
            dataStore.setConnection(connection);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public CmDataStore getDataStore() {
        return dataStore;
    }

    public void setDataStore(CmDataStore dataStore) {
        this.dataStore = dataStore;
    }

    //prueba
    public int countCustomers() {
        return dataStore.countCustomers();
    }


    public int countUser(String user,String pwd) {
        return dataStore.countUser(user,pwd);
    }





    public User findUserWithLogin(String user,String pwd) {
        return dataStore.findUserWithLogin(user,pwd);
    }

    public User findUserById(int id,EmployeesEntity employeesEntity) {
        return dataStore.findUserById(id,employeesEntity);
    }


    /*
    public Customer createCustomer(String code,String dni,String name,String lastName,
     int age,String mail) {
        return dataStore.createCustomer(code,dni,name,lastName,age,mail);

    }

    */

/*

    public Customer1 createCustomer1(int personId, String code, String dni, String name, String lastName, int age,
                                     String mail, String personStatus, String status) {
        return dataStore.createCustomer(personId,code,dni,name,lastName,age,mail,personStatus,status);

    }

*/

    public List<Sector> findByEmploye(int employe_id,EmployeesEntity employeesEntity,CustomersEntity customersEntity){
        return dataStore.findByEmploye(employe_id,employeesEntity,customersEntity);
    }



    public boolean updateCustomer(int id,String code,String dni,String name, String lastName, int age,String mail, String status)
    { return dataStore.updateCustomer(id,code,dni,name,lastName,age,mail,status); }

    public boolean updateEmploye(int id,String code,String dni,String name, String lastName, int age,String mail, String status,String startDate,String endDate)
    { return dataStore.updateEmploye(id,code,dni,name,lastName,age,mail,status,startDate,endDate); }

    public Customer findCustomerById(int id) { return dataStore.findCustomerById(id); }

    public Employe findEmployeById(int id) { return dataStore.findEmployeById(id); }

    public List<Customer> findAllCustomers() {
        return dataStore.findAllCustomer();
    }

    public List<Employe> findAllEmployees() {
        return dataStore.findAllEmployees();
    }

    public Customer createCustomer(int id,String code,String dni,String name,String lastName,int age,String mail, String status)
    { return dataStore.createCustomer(id,code,dni,name,lastName,age,mail,status); }

    public Employe createEmploye(int id,String code,String dni,String name,String lastName,int age,String mail,String status,String startDate,String endDate) {
      return dataStore.createEmploye(id,code,dni,name,lastName,age,mail,status,startDate,endDate);
    }

    public boolean eraseEmploye(int id) {
        return dataStore.eraseEmploye(id);
    }

    public boolean eraseCustomer(int id) {
        return dataStore.eraseCustomer(id);
    }




/*

    public List<Assignment> findAllAssignments() { return dataStore.findAllAssignment(); }
/**//*
    public User findUserById (int id) {
        return dataStore.findUserById(id);
    }*/
/*
    public List<Employe> findAllEmployes() { return dataStore.findAllEmploye(); }*/
/*
    public List<User> findAllUser() { return dataStore.findAllUser(); }
*/
    public List<Loan> findAllLoans() { return dataStore.findAllLoan(); }

    public Loan findLoanById (int id) { return dataStore.findLoanById(id); }









/*
    public Visit findVisitById (int id) { return dataStore.findVisitById(id); }*/
/*
    public List<Visit> findAllVisits() { return dataStore.findAllVisit(); }*/

}