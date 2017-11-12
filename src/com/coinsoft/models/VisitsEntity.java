package com.coinsoft.models;

import java.sql.Connection;

public class VisitsEntity extends BaseEntity {
    public VisitsEntity(Connection connection, String tableName) {
        super(connection, tableName);
    }

    public VisitsEntity() {
        super();
        setTableName("visits");
    }

}
