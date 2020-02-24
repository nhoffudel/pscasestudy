package com.github.nhoffudel;

import com.github.nhoffudel.utils.DirectoryReference;
import com.github.nhoffudel.utils.FileReader;
import org.mariadb.jdbc.Driver;

import java.io.File;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConfigurator {
    static {
        // Attempt to register JDBC Driver
        try {
            DriverManager.registerDriver(Driver.class.newInstance());
        } catch (InstantiationException | IllegalAccessException | SQLException e1) {
            throw new Error(e1);
        }
    }

    private static final DatabaseConnection dbc = DatabaseConnection.VEHICLE_MANAGEMENT_SYSTEM;

    public static void initialize() {
        dbc.use();
    }

    private static void createTable(String fileName) {
        File creationStatementFile = DirectoryReference.RESOURCE_DIRECTORY.getFileFromDirectory(fileName);
        FileReader fileReader = new FileReader(creationStatementFile.getAbsolutePath());
        String creationStatement = fileReader.toString();
        dbc.executeStatement(creationStatement);
    }

    private static void populateTable(String fileName) {
        File insertStatementFile = DirectoryReference.RESOURCE_DIRECTORY.getFileFromDirectory(fileName);
        FileReader fileReader = new FileReader(insertStatementFile.getAbsolutePath());
        String[] insertStatement = fileReader.toString().split(";");
        for (String s : insertStatement)
            dbc.executeUpdate(s);
    }
}
