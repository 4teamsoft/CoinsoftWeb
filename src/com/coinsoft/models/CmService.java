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


    public Customer findCustomerById(int id) {
        return dataStore.findCustomerById(id);
    }

    public List<Customer> findAllCustomers() {
        return dataStore.findAllCustomer();
    }

    public Customer createCustomer(String code,String dni,String name,String lastName,int age,String main,String type,String status) { return dataStore.createCustomer(code,dni,name,lastName,age,main,type,status);}

/*

    public Assignment findAssignmentById (int id) {
        return dataStore.findAssignmentById(id);
    }
/*
    public Employe findEmployeById (int id) {
        return dataStore.findEmployeById(id);
    }*/
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

/*
package com.coinsoft.models;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
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

    public Connection getConnection() { return connection; }

    public void setConnection(Connection connection) {this.connection = connection; }

    public CmDataStore getDataStore() { return dataStore; }

    public void setDataStore(CmDataStore dataStore) {  this.dataStore = dataStore;  }



    public Customer findCustomerById (int id) {
        return dataStore.findCustomerById(id);
    }
    public Quota findQuotaById(int id) { return dataStore.findQuotaById(id); }
    public Employe findEmployeById (int id) {
        return dataStore.findEmployeById(id);
    }
    public User findUserById (int id) {
        return dataStore.findUserById(id);
    }
    public Loan findLoanById (int id) { return dataStore.findLoanById(id); }
    public Visit findVisitById (int id) { return dataStore.findVisitById(id); }
    public Role findRoleById(int id) {return dataStore.findRoleById(id);}
    public TypeCustomer findTypeCustomerById(int id) { return dataStore.findTypeCustomerById(id); }
    public AuditTrail findAuditTrailById(int id) { return dataStore.findAuditTrailById(id); }

    public List<Employe> findAllEmployes() { return dataStore.findAllEmploye(); }
    public List<User> findAllUsers() { return dataStore.findAllUsers(); }
    public List<Loan> findAllLoans() { return dataStore.findAllLoans(); }
    public List<Visit> findAllVisits() { return dataStore.findAllVisits(); }
    public List<Customer> findAllCustomers() { return dataStore.findAllCustomers(); }
    public List<AuditTrail> findAllAudiTrails() { return dataStore.findAllAudiTrails(); }
    public List<Quota> findAllInstallments() {return dataStore.findAllInstallments();}
    public List<Role> findAllRoles() { return dataStore.findAllRoles(); }
    public List<TypeCustomer> findAllTypeCustomers() {return dataStore.findAllTypeCustomers();  }



    public boolean createAuditTrail(int id, String type, Date dateTime, String affectedTable, String detail, String status) {
        return dataStore.createAuditTrail(id,type, dateTime, affectedTable, detail, status);
    }
    public boolean createCustomer(int id, String code,String dni, String name, String lastName, int age, String mail,String status, TypeCustomer typeCustomer) {
        return dataStore.createCustomer(id, code, dni , name, lastName, age, mail, status,typeCustomer);
    }




    public boolean updateAuditTrail(AuditTrail auditTrail) {
        return dataStore.updateAuditTrail(auditTrail.getId(), auditTrail.getType(), auditTrail.getDateTime(),
                auditTrail.getAffectedTable(), auditTrail.getDetail(), auditTrail.getStatus());
    }
    public boolean updateAuditTrail(int id, String type, Date dateTime,String affectedTable,String detail,String status) {
        return dataStore.updateAuditTrail(id, type, dateTime, affectedTable, detail, status);
    }
    public boolean updateCustomer(Customer customer) {
        return dataStore.updateCustomer(customer.getId(), customer.getCode(), customer.getDni(), customer.getName(),
                customer.getLastName(), customer.getAge(), customer.getMail(), customer.getStatus(), customer.getTypeCustomer());
    }
    public boolean updateCustomer(int id, String code,String dni, String name, String lastName, int age, String mail,String status, TypeCustomer typeCustomer) {
        return dataStore.updateCustomer(id, code, dni, name, lastName, age, mail, status, typeCustomer);
    }




    public boolean eraseAuditTrail(int id) { return dataStore.eraseAuditTrail(id); }
    public boolean eraseCustomer(int id) {  return dataStore.eraseCustomer(id);  }



}
266
 */