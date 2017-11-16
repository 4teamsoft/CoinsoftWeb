package com.coinsoft.models;

import java.sql.Connection;

public class VisitsEntity extends BaseEntity {
    public VisitsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }
/*
    public Visit findById(int id, UsersEntity usersEntity, CustomersEntity customersEntity) {
        return findByCriteria(
                String.format("WHERE id = %d", id), usersEntity,customersEntity).get(0);
    }*/
/*
    public List<Visit> findByCriteria(String criteria, UsersEntity usersEntity, CustomersEntity customersEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Visit> visits = new ArrayList<>();
            while(rs.next())
                visits.add(Visit.from(rs, usersEntity,customersEntity));

            return visits;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }*/

    public VisitsEntity() {
    }
/*
    public List<Visit> findAll(UsersEntity usersEntity, CustomersEntity customersEntity) {
        return findByCriteria("", usersEntity,customersEntity);
    }*/

}
