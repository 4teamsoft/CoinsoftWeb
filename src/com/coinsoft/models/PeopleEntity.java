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

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM people";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            return resultSet.next() ? resultSet.getInt("max_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Person create(Person person) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id, code, dni, name, last_name, age , mail) VALUES(%d,'%s','%s','%s','%s',%d,'%s')", getTableName(),person.getId(),
                person.getCode(),person.getDni(),person.getName(),person.getLastName(),person.getAge(),person.getMail())) ? person : null;
    }

    public Person create(String code, String dni, String name, String lastName, int age, String mail) {
        return create(new Person(getMaxId() + 1, code, dni, name, lastName, age, mail));
    }

    public Person create(int id, String code, String dni, String name, String lastName, int age, String mail) {
        return create(new Person(id,code,dni, name, lastName, age, mail));
    }


}