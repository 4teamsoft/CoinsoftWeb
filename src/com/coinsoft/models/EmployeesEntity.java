package com.coinsoft.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesEntity extends BaseEntity{

    public EmployeesEntity() {
        super();
        setTableName("employees");

    }

    public EmployeesEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }


    public List<Employe> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<Employe> employees = new ArrayList<>();
            while (rs.next())
                employees.add(Employe.from(rs));

            return employees;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public Employe findById(int id) {
        return findByCriteria(
                String.format("WHERE id = '%d'", id)).get(0);
    }

    public Employe findByName(String name) {
        return findByCriteria(
                String.format("WHERE name = '%s'", name)).get(0);
    }

    public Employe findByDNI(String dni) {
        return findByCriteria(
                String.format("WHERE dni = '%s'", dni)).get(0);
    }

    public Employe findByLastName(String lastName) {
        return findByCriteria(
                String.format("WHERE last_name = '%s'", lastName)).get(0);
    }

    public List<Employe> findAll() {
        return findByCriteria("");
    }


    public List<Employe> findAllWithManagement() {
        return findByCriteria("id IN (SELECT DISTINCT employe_id FROM visits)");
    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM employees";
        try {
            ResultSet resultSet = getConnection().createStatement().executeQuery(sql);
            return resultSet.next() ? resultSet.getInt("max_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public Employe create(Employe employe) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id,code,dni, name, last_name, age , mail, status ) " +
                        "VALUES(%d,'%s','%s', '%s', '%s',%d,'%s','%s')",
                getTableName(), employe.getId(), employe.getCode(), employe.getDni(), employe.getName(), employe.getLastName(), employe.getAge(), employe.getMail(), employe.getStatus())) ? employe : null;
    }

    public Employe create(String code,String dni,String name, String lastName, int age,String mail, String status) {
        return create(new Employe(getMaxId() + 1,code,dni, name, lastName, age, mail, status));
    }

    public Employe create(int id,String code,String dni,String name, String lastName, int age,String mail, String status) {
        return create(new Employe(id,code,dni, name, lastName, age, mail, status));
    }

    //id, code, dni, name, lastName, age, mail, status
    public boolean update(int id,String code,String dni,String name, String lastName, int age,String mail, String status) {
        return executeUpdate(String.format(
                "UPDATE %s SET code = '%s',dni = '%s',name = '%s', last_name='%s', age=%d,mail = '%s', status='%s' WHERE id = %d",
                getTableName(),code,dni, name, lastName, age,mail, status, id));
    }

    public boolean update(Employe employe) {
        return update(employe.getId(),employe.getCode(),employe.getDni(),employe.getName(), employe.getLastName(),
                employe.getAge(), employe.getMail(),employe.getStatus());
    }


    public boolean erase(int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = %d",
                getTableName(), id));
    }

    public boolean erase(Employe employe) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = %d",
                getTableName(), employe.getId()));

    }



}
