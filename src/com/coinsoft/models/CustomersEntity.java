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
        return findByCriteria("");
    }

/*
    public List<Customer> findAllWithManagement() {
        return findByCriteria("customer_id IN (SELECT DISTINCT customer_id FROM managements)");
    }*/
/*
    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM customers";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            return resultSet.next() ? resultSet.getInt("max_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }*/


    public Customer create(Customer customer) {
        return executeUpdate(String.format(
                "INSERT INTO %s(code,dni, name, last_name, age , mail,type, status ) VALUES(%d,'%s','%s', '%s', '%s',%d,'%s','%s')", getTableName(), customer.getCode(), customer.getDni(), customer.getName(), customer.getLastName(), customer.getAge(), customer.getMail(), customer.getStatus())) ? customer : null;
    }

    public Customer create(String code,String dni,String name, String lastName, int age,String mail,String type, String status) {
        return create(new Customer(code,dni, name, lastName, age, mail,type, status));
    }

    //id, code, dni, name, lastName, age, mail, status
    public boolean update(int customer_id,String code,String dni,String name, String lastName, int age,String mail, String status) {
        return executeUpdate(String.format(
                "UPDATE %s SET code = '%s',dni = '%s',name = '%s', last_name='%s', age=%d,mail = '%s', status='%s' WHERE customer_id = %d",
                getTableName(),code,dni, name, lastName, age,mail, status, customer_id));
    }

    public boolean update(Customer customer) {
        return update(customer.getId(),customer.getCode(),customer.getDni(),customer.getName(), customer.getLastName(),
                customer.getAge(), customer.getMail(),customer.getStatus());
    }


    public boolean erase(int customer_id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE customer_id = %d",
                getTableName(), customer_id));
    }

    public boolean erase(Customer customer) {
        return executeUpdate(String.format("DELETE FROM %s WHERE customer_id = %d",
                getTableName(), customer.getId()));
    }


}