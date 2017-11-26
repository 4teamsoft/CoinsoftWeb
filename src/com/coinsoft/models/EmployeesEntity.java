package com.coinsoft.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeesEntity extends BaseEntity{

    public EmployeesEntity() {
        super();
        setTableName("Employes");

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
        return findByCriteria("e INNER JOIN people p ON e.id=p.id");
    }

    /*
    public List<Employe> findAllWithManagement() {
        return findByCriteria("id IN (SELECT DISTINCT employe_id FROM visits)");
    }*/




    public Employe create(int personID, String code, String dni, String name, String lastName, int age, String mail, String status,String startDate,String endDate) {
        return create(new Employe(personID,code,dni,name,lastName,age,mail,status,startDate,endDate));
    }

    public Employe create(Employe employe) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id,start_date,end_date,employe_status) VALUES(%d,'%s','%s','1')", getTableName(), employe.getId(),employe.getStartDate(),employe.getEndDate())) ? employe : null;

    }

    /*
    public Employe create(int id,String code,String dni,String name, String lastName, int age,String mail, String status,Date startDate,Date endDate) {
        return create(new Employe(id,code,dni, name, lastName, age, mail, status,startDate,endDate));
    }


    public boolean update(int id,String code,String dni,String name, String lastName, int age,String mail, String status,String startDate,Date endDate) {
        return executeUpdate(String.format(
                "UPDATE %s SET code = '%s',dni = '%s',name = '%s', last_name='%s', age=%d,mail = '%s', status='%s' WHERE id = %d",
                getTableName(),code,dni, name, lastName, age,mail, status, id));
    }
    public boolean update(Employe employe) {
        return update(employe.getId(),employe.getCode(),employe.getDni(),employe.getName(), employe.getLastName(),
                employe.getAge(), employe.getMail(),employe.getStatus(),employe.getStartDate(),employe.getEndDate());
    }*/

    public boolean update(int id,String startDate,String endDate,String code,String dni,String name, String lastName, int age,String mail, String status) {
        return executeUpdate(String.format(
                "UPDATE %s SET startDate = '%s', endDate = '%s' WHERE id = %d,",
                getTableName(),startDate,endDate, id));
    }


    public boolean update(Employe employe) {
        return update(employe.getId(),employe.getStartDate(),employe.getEndDate(),employe.getCode(),employe.getDni(), employe.getName(),
                employe.getLastName(), employe.getAge(),employe.getMail(),employe.getStatus());
    }
    /*
    public boolean erase(int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = %d",
                getTableName(), id));
    }
    public boolean erase(Employe employe) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = %d",
                getTableName(), employe.getId()));
    }

*/
}