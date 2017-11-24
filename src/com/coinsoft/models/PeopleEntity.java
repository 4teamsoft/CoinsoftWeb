package com.coinsoft.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeopleEntity extends BaseEntity{

    public PeopleEntity() {
        super();
        setTableName("people");
    }

    public PeopleEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public List<Person> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<Person> people = new ArrayList<>();
            while (rs.next())
                people.add(Person.from(rs));

            return people;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM people";
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            return resultSet.next() ?
                    resultSet.getInt("max_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public Person findById(int id) {
        return findByCriteria(
                String.format("WHERE id = '%d'", id)).get(0);
    }

    public Person findByName(String name) {
        return findByCriteria(
                String.format("WHERE name = '%s'", name)).get(0);
    }

    public Person findByDNI(String dni) {
        return findByCriteria(
                String.format("WHERE dni = '%s'", dni)).get(0);
    }

    public Person findByLastName(String lastName) {
        return findByCriteria(
                String.format("WHERE last_name = '%s'", lastName)).get(0);
    }






    //1
    public Person create(String code, String dni, String name, String lastName, int age, String mail,String status) {
        return create(getMaxId()+1,code,dni, name, lastName, age, mail,status);
    }

    //2
    public Person create(int id,String code, String dni, String name, String lastName, int age, String mail,String status) {
        return create(new Person(id,code,dni, name, lastName, age, mail,status));
    }

    //3
    public Person create(Person person) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id,code,dni,name,last_name,age,mail,status) VALUES(%d,'%s','%s','%s','%s',%d,'%s','1')",
                getTableName(),person.getId(),person.getCode(),person.getDni(),person.getName(),person.getLastName(),person.getAge(),person.getMail())) ? person : null;
    }




    public boolean update(int id,String code,String dni,String name, String lastName, int age,String mail, String status) {
        return executeUpdate(String.format(
                "UPDATE %s SET code = '%s',dni = '%s',name = '%s', last_name='%s', age=%d,mail = '%s', status='%s' WHERE id = %d",
                getTableName(),code,dni, name, lastName, age,mail, '1', id));
    }

    public boolean update(Person person) {
        return update(person.getId(),person.getCode(),person.getDni(),person.getName(), person.getLastName(),
                person.getAge(), person.getMail(),person.getStatus());
    }


    public boolean erase(int id) {
        return executeUpdate(String.format("UPDATE %s SET status='%s' WHERE id = %d",
                getTableName(),'0', id));
    }

    public boolean erase(Person person) {
        return executeUpdate(String.format("UPDATE %s SET status='%s' WHERE id = %d",
                getTableName(),'0', person.getId()));
    }




}