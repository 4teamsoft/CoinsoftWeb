package com.coinsoft.models;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersEntity extends BaseEntity {

    public UsersEntity() {
        super();
        setTableName("users");
    }

    public UsersEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }


    public List<User> findByCriteria(String criteria) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(getBaseStatement().concat(criteria));
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(User.from(rs));
            }

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public User findUserWithLogin(String user,String pwd) {
        return findByCriteria(
                String.format("WHERE user = '%s' and pwd = '%s'", user,pwd )).get(0);
    }

    public User create(User user) {
        return executeUpdate(String.format(
                "INSERT INTO %s(user, password, type, status, employeId) VALUES('%s','%s','%s','%s',%d)", getTableName(),user.getUser(),
                user.getPassword(),user.getType(),user.getStatus())) ? user : null;
    }

    public User create(String user, String password, String type, String status, int employedId) {
        return create(new User(user, password, type, status, employedId));
    }

}
