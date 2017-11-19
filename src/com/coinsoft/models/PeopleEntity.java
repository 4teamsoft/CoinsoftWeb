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
            List<Person> person = new ArrayList<>();
            while (rs.next())
                person.add(Person.from(rs));

            return person;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public Person create(Person person) {
        return executeUpdate(String.format(
                "INSERT INTO %s(code,dni,name,last_name,age,mail,personStatus) VALUES('%s','%s','%s','%s',%d,'%s','1')", getTableName(),person.getCode(),person.getDni(),person.getName(),person.getLastName(),person.getAge(),person.getMail())) ? person : null;
    }

    public Person create(String code, String dni, String name, String lastName, int age, String mail) {
        return create(new Person(code,dni, name, lastName, age, mail));
    }


}