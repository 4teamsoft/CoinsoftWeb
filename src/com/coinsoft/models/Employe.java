package com.coinsoft.models;

public class Employe extends Person {
    private Employe manager;
    private Employe admin;

    public Employe() {
    }

    /*
        public Employe(int id, String code, String dni, String name, String lastName, int age, String mail, String status) {
            super(id, code, dni, name, lastName, age, mail, status);
        }
        public Employe(int id, String code, String dni, String name, String lastName, int age, String mail, String status, Employe manager, Employe admin) {
            super(id, code, dni, name, lastName, age, mail, status);
            this.setManager(manager);
            this.setAdmin(admin);
        }*/
    public Employe(String code, String dni, String name, String last_name, int age, String mail, String status, Employe manager, Employe admin) {
        this.manager = manager;
        this.admin = admin;
    }

    public Employe(String code, String dni, String name, String lastName, int age, String mail) {
        super(code, dni, name, lastName, age, mail);
    }

    public Employe(String code, String dni, String name, String lastName, int age, String mail, Employe manager, Employe admin) {
        super(code, dni, name, lastName, age, mail);
        this.manager = manager;
        this.admin = admin;
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
/*
    public static Employe from(ResultSet rs, EmployeesEntity employeesEntity) {
        try {
            return new Employe(
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
    }*/





}