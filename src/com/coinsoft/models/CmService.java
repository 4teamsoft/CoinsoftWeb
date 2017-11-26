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
/*
    public int countCustomers() {
        return dataStore.countCustomers();
    }
*/
/*
    public int countUser(String user,String pwd) {
        return dataStore.countUser(user,pwd);
    }*/




/*
    public User findUserWithLogin(String user,String pwd) {
        return dataStore.findUserWithLogin(user,pwd);
    }
*/





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


    public boolean updateCustomer(int id,String code,String dni,String name, String lastName, int age,String mail, String status)
    { return dataStore.updateCustomer(id,code,dni,name,lastName,age,mail,status); }

    public Customer findCustomerById(int id) { return dataStore.findCustomerById(id); }

    public List<Customer> findAllCustomers() {
        return dataStore.findAllCustomer();
    }

    public Customer createCustomer(int id,String code,String dni,String name,String lastName,int age,String mail, String status)
    { return dataStore.createCustomer(id,code,dni,name,lastName,age,mail,status); }

    public Employe createEmploye(int id, String code, String dni, String name, String lastName, int age,
                                   String mail, String status, String startDate,String endtDate) {
      return dataStore.createEmploye(id,code,dni,name,lastName,age,mail,status,startDate,endtDate);
    }
    public boolean updateEmploye(int id,String startDate,String endDate,String code,String dni,String name, String lastName, int age,String mail, String status)
    { return dataStore.updateEmploye(id,startDate,endDate,code,dni,name,lastName,age,mail,status); }


    public Employe findEmployeById (int id) {
            return dataStore.findEmployeById(id);
        }
/*
    public List<Assignment> findAllAssignments() { return dataStore.findAllAssignment(); }
/**//*
    public User findUserById (int id) {
        return dataStore.findUserById(id);
    }*/

    public List<Employe> findAllEmployees() { return dataStore.findAllEmploye(); }
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