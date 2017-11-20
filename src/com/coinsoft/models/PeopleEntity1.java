package com.coinsoft.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeopleEntity1 extends BaseEntity{

    public PeopleEntity1() {
        super();
        setTableName("people1");
    }

    public PeopleEntity1(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public List<Person1> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<Person1> person1 = new ArrayList<>();
            while (rs.next())
                person1.add(Person1.from(rs));

            return person1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    private int getMaxId() {
        String sql = "SELECT MAX(person_id) AS max_id FROM people1";
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


    public Person1 create(Person1 person1) {
        return executeUpdate(String.format(
                "INSERT INTO %s(person_id,code,dni,name,last_name,age,mail,person_status) VALUES(%d,'%s','%s','%s','%s',%d,'%s','1')",
                getTableName(),person1.getPersonId(),person1.getCode(),person1.getDni(),person1.getName(),person1.getLastName(),person1.getAge(),person1.getMail())) ? person1 : null;
    }

    public Person1 create(int personId,String code, String dni, String name, String lastName, int age, String mail,String personStatus) {
        return create(new Person1(personId,code,dni, name, lastName, age, mail,personStatus));
    }

    public Person1 create(String code, String dni, String name, String lastName, int age, String mail,String personStatus) {
        return create(getMaxId()+1,code,dni, name, lastName, age, mail,personStatus);
    }

    public boolean update(int person_id,String code,String dni,String name, String lastName, int age,String mail, String status) {
        return executeUpdate(String.format(
                "UPDATE %s SET code = '%s',dni = '%s',name = '%s', last_name='%s', age=%d,mail = '%s', person_status='%s' WHERE person_id = %d",
                getTableName(),code,dni, name, lastName, age,mail, status, person_id));
    }

    public boolean update(Person1 person1) {
        return update(person1.getPersonId(),person1.getCode(),person1.getDni(),person1.getName(), person1.getLastName(),
                person1.getAge(), person1.getMail(),person1.getPersonStatus());
    }


    public boolean erase(int personId) {
        return executeUpdate(String.format("UPDATE %s SET person_status='%s' WHERE person_id = %d",
                getTableName(),'0', personId));
    }

    public boolean erase(Person1 person1) {
        return executeUpdate(String.format("UPDATE %s SET person_status='%s' WHERE person_id = %d",
                getTableName(),'0', person1.getPersonId()));
    }




}