package com.coinsoft.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SectorsEntity extends BaseEntity{

    public SectorsEntity(){
        super();
        setTableName("sectors");

    }



    public List<Sector> findByCriteria(String criteria, EmployeesEntity employeesEntity,CustomersEntity customersEntity) {
        try {
            ResultSet rs = getConnection()
                    .createStatement()
                    .executeQuery(
                            getBaseStatement()
                                    .concat(criteria));
            List<Sector> sectors = new ArrayList<>();
            while(rs.next())
                sectors.add(Sector.from(rs,employeesEntity ,customersEntity));

            return sectors;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    private int getMaxId() {
        String sql = "SELECT MAX(id) AS max_id FROM sectors";
        try {
            ResultSet resultSet = getConnection()
                    .createStatement()
                    .executeQuery(sql);
            return resultSet.next() ?
                    resultSet.getInt("max_id") : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Sector findById(int id, EmployeesEntity employeesEntity,CustomersEntity customersEntity) {
        return findByCriteria(
                String.format("WHERE id = %d", id), employeesEntity,customersEntity).get(0);
    }

    public List<Sector> findByEmploye(int employe_id,EmployeesEntity employeesEntity,CustomersEntity customersEntity){
        return findByCriteria(
                String.format("WHERE employe_id = %d", employe_id), employeesEntity,customersEntity);
    }


    public List<Sector> findAll(EmployeesEntity employeesEntity, CustomersEntity customersEntity)
    { return findByCriteria("", employeesEntity,customersEntity); }

    public boolean create(Sector sector) {
        int id = getMaxId() + 1;
        return executeUpdate(String.format("INSERT INTO %s(id, name, detail,status,employe_id,customer_id) VALUES(%d,'%s','%s','1',%d , %d )",
                getTableName(), id,sector.getName(),sector.getDetail(),sector.getEmploye().getId(),sector.getCustomer().getId()));
    }


    public boolean update(int id, String name,String detail,String status,Employe employe,Customer customer) {
        return executeUpdate(String.format(
                "UPDATE %s SET name = '%s',detail = '%s',status = '1',employe_id = %d,customer_id = %d WHERE id = %d",
                getTableName(), name, detail, employe.getId(),customer.getId(),id));
    }

    public boolean update(Sector sector) {
        return update(sector.getId(), sector.getName(),sector.getDetail(),sector.getStatus(),sector.getEmploye(),sector.getCustomer());
    }


    public boolean erase(int id) {
        return executeUpdate(String.format("UPDATE %s SET status = '0' WHERE id = %d ",
                getTableName(), id));
    }
    public boolean erase(Sector sector) {
        return executeUpdate(String.format("UPDATE %s SET status = '0' WHERE id = %d",
                getTableName(), sector.getId()));
    }




}
