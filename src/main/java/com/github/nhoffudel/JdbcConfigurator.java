package com.github.nhoffudel;

import com.github.nhoffudel.utils.DirectoryReference;
import com.github.nhoffudel.utils.FileReader;
import com.github.nhoffudel.utils.IOConsole;
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
//        if (getOverwriteInput().equals("yes")){
//            createTable("vehicle_management_system_create.sql");
//        }
        dbc.use();
    }

    private static String getOverwriteInput() {
        IOConsole console = new IOConsole();
        return console.getStringInput("Do you want to delete the existing database and create a new one?" +
                "\nType yes to delete and create a new one. Warning! All data will be deleted!" +
                "\nType no to use existing database and data.");
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
