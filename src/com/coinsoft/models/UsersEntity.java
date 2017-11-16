package com.coinsoft.models;

/*
public class UsersEntity extends BaseEntity {
    public UsersEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }
/*
    public UsersEntity() {
        super();
        setTableName("users");
    }*/
/*
    public User findById(int id, EmployeesEntity employeesEntity) {
        return findByCriteria(
                String.format("WHERE id = %d", id), employeesEntity).get(0);
    }*/
/*
    public List<User> findByCriteria(String criteria, EmployeesEntity employeesEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<User> users = new ArrayList<>();
            while(rs.next())
                users.add(User.from(rs, employeesEntity));

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
*/
/*
    public User findByUser(String user, EmployeesEntity employeesEntity) {
        return findByCriteria(
                String.format("WHERE user = '%s'", user), employeesEntity).get(0);
    }*/
/*
    public List<User> findAll(EmployeesEntity employeesEntity) {
        return findByCriteria("", employeesEntity);
    }*/
/*
    public boolean create(User user) {
        return executeUpdate(String.format(
                "INSERT INTO %s(id, user, password, type , status, employe_id) VALUES(%d,'%s', '%s', %d, '%s',%d)",
                getTableName(), user.getId(), user.getUser(), user.getPassword(),user.getType(),
                user.getStatus(), user.getEmploye().getId()));
    }

    public boolean create(int id, String user,String password, int type, String status, Employe employe) {
        return create(new User(id, user,password,type,status, employe));
    }



    public boolean update(int id, String user, String password, int type, String status, Person employe) {
        return executeUpdate(String.format(
                "UPDATE %s SET user = '%s',password = '%s',type = %d,status = '%s',employe_id = %d WHERE id = %d",
                getTableName(), user, password, type,status,employe.getId(),id));
    }




    public boolean update(User user) {
        return update(user.getId(), user.getUser(),user.getPassword(),
                user.getType(),user.getStatus(),user.getEmploye());
    }

    public boolean erase(int id) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = %d",
                getTableName(), id));
    }

    public boolean erase(User user) {
        return executeUpdate(String.format("DELETE FROM %s WHERE id = %d",
                getTableName(), user.getId(), user.getEmploye()));
    }

    public User findById(int user_id) {
        return null;
    }


}*/
