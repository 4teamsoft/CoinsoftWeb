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

    public Customer findById(int id) {
        return findByCriteria(
                String.format("WHERE id = %d ", id)).get(0);
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
        return findByCriteria("c INNER JOIN people p ON c.id=p.id where c.status='1'");
    }


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




    public Customer create(Customer customer) {
       return executeUpdate(String.format(
                "INSERT INTO %s(id,status) VALUES(%d,'1') ", getTableName(), customer.getId())) ? customer : null;
    }

    public Customer create(int id,String code, String dni, String name, String lastName, int age, String mail, String status/*,PeopleEntity peopleEntity*/) {
        return create(new Customer(id,code,dni, name, lastName, age, mail,status));
    }

    public boolean update(int id,String code,String dni,String name, String lastName, int age,String mail, String status) {
        return executeUpdate(String.format(
                "UPDATE %s SET status = '1' WHERE id = %d",
                getTableName(),id));
    }


    public boolean update(Customer customer) {
        return update(customer.getId(),customer.getCode(),customer.getDni(), customer.getName(),
                customer.getLastName(), customer.getAge(),customer.getMail(),customer.getStatus());
    }

    public boolean erase(int id) {
        return executeUpdate(String.format("UPDATE %s SET status = '0' WHERE id = %d ",
                getTableName(), id));
    }
    public boolean erase(Customer customer) {
        return executeUpdate(String.format("UPDATE %s SET status = '0' WHERE id = %d",
                getTableName(), customer.getId()));
    }


}






