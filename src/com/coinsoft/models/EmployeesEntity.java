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
            ResultSet rs = getConnection().createStatement().executeQuery(getBaseStatement().concat(criteria));
            List<Employe> employes = new ArrayList<>();
            while (rs.next())
                //Pendiente arreglar parte de este codigo
                //employes.add(Employe.from(rs,));

            return employes;
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



    public List<Employe> findAll() {
        return findByCriteria("");
    }




}
