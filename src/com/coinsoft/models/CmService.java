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
                    .lookup("jdbc/MySQLDataSource"))
                    .getConnection();
            dataStore.setConnection(connection);
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) {this.connection = connection; }

    public CmDataStore getDataStore() { return dataStore; }

    public void setDataStore(CmDataStore dataStore) {  this.dataStore = dataStore;  }



    public Customer findCustomerById (int id) {
        return dataStore.findCustomerById(id);
    }

    public List<Customer> findAllCustomers() { return dataStore.findAllCustomer(); }


    public Assignment findAssignmentById (int id) {
        return dataStore.findAssignmentById(id);
    }

    public Employe findEmployeById (int id) {
        return dataStore.findEmployeById(id);
    }

    public List<Assignment> findAllAssignments() { return dataStore.findAllAssignment(); }

    public User findUserById (int id) {
        return dataStore.findUserById(id);
    }

    public List<Employe> findAllEmployes() { return dataStore.findAllEmploye(); }

    public List<User> findAllUsers() { return dataStore.findAllUser(); }



}
