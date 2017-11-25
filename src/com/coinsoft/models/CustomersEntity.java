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
                String.format("WHERE id = '%d'", id)).get(0);
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
        return findByCriteria("c INNER JOIN people p ON c.id=p.id");
    }
    //c INNER JOIN people p ON c.id=p.id


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



    /*
    public Customer create(Person person) {
        return create(new Customer(person.getCode(),person.getDni(),person.getName(),person.getLastName(),person.getAge(),person.getMail()));
    }
    */
    public boolean erase(int id) {
        return executeUpdate(String.format("UPDATE %s SET status='%s' WHERE id = %d",
                getTableName(),'0', id));
    }

    public boolean erase(Customer customer) {
        return executeUpdate(String.format("UPDATE %s SET status='%s' WHERE id = %d",
                getTableName(),'0', customer.getId()));
    }

    //2
    public Customer create(Customer customer) {
        //PeopleEntity p=new PeopleEntity();
       // p.create(customer.getCode(),customer.getDni(),customer.getName(),customer.getLastName()
        //       ,customer.getAge(),customer.getMail(),customer.getStatus());
       return executeUpdate(String.format(
                "INSERT INTO %s(id) VALUES(%d)", getTableName(), customer.getId())) ? customer : null;
    }
    //1
    public Customer create(int id,String code, String dni, String name, String lastName, int age, String mail, String status/*,PeopleEntity peopleEntity*/) {
        //Person person=peopleEntity.create(id,code, dni, name, lastName, age, mail, status);
        return create(new Customer(id,code,dni, name, lastName, age, mail,status));
    }

    /*
    public Customer update(Customer customer) {
        return executeUpdate(String.format(
                "UPDATE %s SET id = %d  WHERE id = %d",
                getTableName(),customer.getId(),customer.getId()))? customer : null;
    }

    public Customer update(int id,String code,String dni,String name, String lastName, int age,String mail, String status) {
        return update(new Customer(id,code,dni, name, lastName, age, mail,status));
*/

    public boolean update(int id,String code,String dni,String name, String lastName, int age,String mail, String status) {
        return executeUpdate(String.format(
                "UPDATE %s SET id = %d WHERE id = %d",
                getTableName(),id, id));
    }


    public boolean update(Customer customer) {
        return update(customer.getId(),customer.getCode(),customer.getDni(), customer.getName(),
                customer.getLastName(), customer.getAge(),customer.getMail(),customer.getStatus());
    }





        /*return executeUpdate(String.format(
                "UPDATE %s SET code = '%s',dni = '%s',name = '%s', last_name='%s', age=%d,mail = '%s', status='%s' WHERE id = %d",
                getTableName(),code,dni, name, lastName, age,mail, '1', id));*/

    }






