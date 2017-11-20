package com.coinsoft.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersEntity extends BaseEntity {

    public CustomersEntity() {
        super();
        setTableName("customers");
    }

    public CustomersEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }


    public List<Customer> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<Customer> customers = new ArrayList<>();
            while (rs.next())
                customers.add(Customer.from(rs));

            return customers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public Customer findById(int customer_id) {
        return findByCriteria(
                String.format("WHERE customer_id = '%d'", customer_id)).get(0);
    }

    public Customer findByName(String name) {
        return findByCriteria(
                String.format("WHERE name = '%s'", name)).get(0);
    }

    public Customer findByDNI(String dni) {
        return findByCriteria(
                String.format("WHERE dni = '%s'", dni)).get(0);
    }

    public Customer findByLastName(String lastName) {
        return findByCriteria(
                String.format("WHERE last_name = '%s'", lastName)).get(0);
    }

    public List<Customer> findAll() {
        return findByCriteria("c INNER JOIN people p ON c.person_id=p.person_id");
    }

/*
    public List<Customer> findAllWithManagement() {
        return findByCriteria("customer_id IN (SELECT DISTINCT customer_id FROM managements)");
    }*/

    public int countCustomers() {

        String query="SELECT count(*) From customers";
        int count=0;
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(query);
            while(rs.next())
                count=rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    /*private int getMaxId() {

        String query="SELECT count(*) From customers";
        int count=0;
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(query);
            while(rs.next())
                count=rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/


/*
    public Customer create(Customer customer){
        executeUpdate(String.format("INSERT INTO people(code,dni,name,last_name,age,mail) VALUES('%s','%s','%s','%s',%d,'%s');",customer.getCode(),customer.getDni(),customer.getName(),customer.getLastName(),customer.getAge(),customer.getMail()));
        executeUpdate(String.format("INSERT INTO customers(type,status,person_id) VALUES('%s','%s',%d);",customer.getType(),customer.getStatus(),getMaxId()));
        return null;
    }*/

    public Customer create(Customer customer) {
        return executeUpdate(String.format(
                "INSERT INTO %s(type,status) VALUES('%s','%s')", getTableName(),customer.getStatus())) ? customer : null;
    }

    public Customer create(String status, Person person) {
        return create(new Customer(person.getPersonId(),person.getCode(),person.getDni(),person.getName(),person.getLastName(),person.getAge(),person.getMail(),person.getPersonStatus(),status));
    }

    //id, code, dni, name, lastName, age, mail, status
    public boolean update(int id,String code,String dni,String name, String lastName, int age,String mail,String personStatus, String status) {
        return executeUpdate(String.format(
                "UPDATE %s SET code = '%s',dni = '%s',name = '%s', last_name='%s', age=%d,mail = '%s', status='%s' WHERE id = %d",
                getTableName(),code,dni, name, lastName, age,mail, status, id));
    }

    public boolean update(Customer customer) {
        return update(customer.getId(),customer.getCode(),customer.getDni(),customer.getName(), customer.getLastName(),
                customer.getAge(), customer.getMail(),customer.getPersonStatus(),customer.getStatus());
    }


    public boolean erase(int customer_id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE customer_id = %d",
                getTableName(), customer_id));
    }

/*
    public boolean erase(Customer customer) {
        return executeUpdate(String.format("DELETE FROM %s WHERE customer_id = %d",
                getTableName(), customer.getId()));
    }*/


}