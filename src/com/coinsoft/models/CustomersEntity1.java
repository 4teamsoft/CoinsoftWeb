package com.coinsoft.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomersEntity1 extends BaseEntity {

    public CustomersEntity1() {
        super();
        setTableName("customers1");
    }

    public CustomersEntity1(Connection connection, String tableName) {
        super(connection, tableName);
    }


    public List<Customer1> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<Customer1> customers1 = new ArrayList<>();
            while (rs.next())
                customers1.add(Customer1.from(rs));

            return customers1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public Customer1 findById(int id) {
        return findByCriteria(
                String.format("WHERE customer_id = '%d'", id)).get(0);
    }

    public Customer1 findByName(String name) {
        return findByCriteria(
                String.format("WHERE name = '%s'", name)).get(0);
    }

    public Customer1 findByDNI(String dni) {
        return findByCriteria(
                String.format("WHERE dni = '%s'", dni)).get(0);
    }

    public Customer1 findByLastName(String lastName) {
        return findByCriteria(
                String.format("WHERE last_name = '%s'", lastName)).get(0);
    }

    public List<Customer1> findAll() {
        return findByCriteria("c INNER JOIN people p ON c.customers_id=p.person_id");
    }

/*
    public List<Customer> findAllWithManagement() {
        return findByCriteria("customer_id IN (SELECT DISTINCT customer_id FROM managements)");
    }*/

    public int countCustomers() {

        String query="SELECT count(*) From customers1";
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

/*
    public Customer create(Customer customer){
        executeUpdate(String.format("INSERT INTO people(code,dni,name,last_name,age,mail) VALUES('%s','%s','%s','%s',%d,'%s');",customer.getCode(),customer.getDni(),customer.getName(),customer.getLastName(),customer.getAge(),customer.getMail()));
        executeUpdate(String.format("INSERT INTO customers(type,status,person_id) VALUES('%s','%s',%d);",customer.getType(),customer.getStatus(),getMaxId()));
        return null;
    }*/

    public Customer1 create(Customer1 customer1) {
        PeopleEntity1 p=new PeopleEntity1();
        p.create(customer1.getCode(),customer1.getDni(),customer1.getName(),customer1.getLastName()
        ,customer1.getAge(),customer1.getMail(),customer1.getPersonStatus());

        return executeUpdate(String.format(
                "INSERT INTO %s(id,status) VALUES(%d,'1')", getTableName(), customer1.getId())) ? customer1 : null;
    }
    /*
    public Customer1 create(Person person) {
        return create(new Customer(person.getCode(),person.getDni(),person.getName(),person.getLastName(),person.getAge(),person.getMail()));
    }
    */
    public boolean erase(int id) {
        return executeUpdate(String.format("UPDATE %s SET person_status='%s' WHERE id = %d",
                getTableName(),'0', id));
    }

    public boolean erase(Customer1 customer1) {
        return executeUpdate(String.format("UPDATE %s SET person_status='%s' WHERE id = %d",
                getTableName(),'0', customer1.getId()));
    }




}