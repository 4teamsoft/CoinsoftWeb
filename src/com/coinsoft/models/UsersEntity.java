package com.coinsoft.models;


import javax.jws.soap.SOAPBinding;
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
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<User> users = new ArrayList<>();
            while(rs.next())
                users.add(User.from(rs));

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public User findUserWithLogin(String user,String pwd) {
        return findByCriteria(
                String.format("WHERE user = '%s' and pwd = '%s'", user,pwd)).get(0);
    }

    public User findById(int id, EmployeesEntity employeesEntity) {
        return findByCriteria(
                String.format("WHERE id = %d", id)).get(0);
    }

    public int countUser(String user,String pwd) {

        String query="SELECT count(*) From users WHERE user='" + user + "' and pwd='" + pwd + "'";
        int count1=0;
        try {
            ResultSet rs = getConnection().createStatement().executeQuery(query);
            while(rs.next())
                count1=rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count1;
    }

}
