package com.github.nhoffudel;

import java.sql.*;

public enum SQLiteDBConnection {
    VEHICLE_MANAGEMENT_SYSTEM("jdbc:sqlite:./src/main/resources/vehicle_management_system.db"),
    VMS_USERS("jdbc:sqlite:./src/main/resources/vms_users.db"),
    VMS_TRIPS("jdbc:sqlite:./src/main/resources/vms_trips.db"),
    VMS_RECORDS("jdbc:sqlite:./src/main/resources/vms_records.db"),
    VMS_VEHICLES("jdbc:sqlite:./src/main/resources/vms_vehicles.db");

    private String url;
    private Connection connection;

    SQLiteDBConnection(String url){
        this.url = url;
        this.connection = build(url);
    }

    public Connection getDatabaseConnection() {
        return connection;
    }

    private Connection build(String url) {
        try {
            DriverManager.registerDriver(new org.sqlite.JDBC());
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            String errorMessage = String.format("Failed to connect to `%s`", url);
            throw new Error(errorMessage, e);
        }
    }

    public Connection getDatabaseEngineConnection() {
        return connection;
    }

    public void use() {
//        try {
//            getDatabaseEngineConnection()
//                    .prepareStatement("USE " + name().toLowerCase() + ";")
//                    .execute();
//        } catch (SQLException e) {
//            throw new Error(e);
//        }
    }

    public void executeStatement(String sqlStatement) {
        try {
            getScrollableStatement().execute(sqlStatement);
        } catch (SQLException e) {
            String errorMessage = String.format("Failed to execute statement `%s`", sqlStatement);
            throw new Error(errorMessage, e);
        }
    }

    public void executeUpdate(String sqlStatement) {
        try {
            getScrollableStatement().executeUpdate(sqlStatement);
        } catch (SQLException e) {
            String errorMessage = String.format("Failed to execute update `%s`", sqlStatement);
            throw new Error(errorMessage, e);
        }
    }

    public ResultSet executeQuery(String sqlQuery) {
        try {
            return getScrollableStatement().executeQuery(sqlQuery);
        } catch (SQLException e) {
            String errorMessage = String.format("Failed to execute query `%s`", sqlQuery);
            throw new Error(errorMessage, e);
        }
    }

    private Statement getScrollableStatement() {
        int resultSetType = ResultSet.TYPE_FORWARD_ONLY;
        int resultSetConcurrency = ResultSet.CONCUR_READ_ONLY;
        try {
            return getDatabaseConnection().createStatement(resultSetType, resultSetConcurrency);
        } catch (SQLException e) {
            throw new Error(e);
        }
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
