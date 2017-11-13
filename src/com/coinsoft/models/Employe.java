package com.coinsoft.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Employe extends Person {
    private Employe manager;
    private Employe admin;



    public Employe(int id, String code, String dni, String name, String lastName, int age, String mail, String status) {
        super(id, code, dni, name, lastName, age, mail, status);

    }

    public Employe(int id, String code, String dni, String name, String lastName, int age, String mail, String status, Employe manager, Employe admin) {
        super(id, code, dni, name, lastName, age, mail, status);
        this.setManager(manager);
        this.setAdmin(admin);
    }

    public Employe getManager() {
        return manager;
    }

    public Employe setManager(Employe manager) {
        this.manager = manager;
        return this;
    }

    public Employe getAdmin() {
        return admin;
    }

    public Employe setAdmin(Employe admin) {
        this.admin = admin;
        return this;
    }


    public static Employe from(ResultSet rs, EmployeesEntity employeesEntity) {
        try {
            return new Employe(
                    rs.getInt("id"),
                    rs.getString("code"),
                    rs.getString("dni"),
                    rs.getString("name"),
                    rs.getString("last_name"),
                    rs.getInt("age"),
                    rs.getString("mail"),
                    rs.getString("status"),
                    employeesEntity.findById(rs.getInt("manager_id")),
                    employeesEntity.findById(rs.getInt("admin_id"))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }





}
