package com.github.nhoffudel.repository;

import com.github.nhoffudel.model.Vehicle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBHandler {

    public DBHandler() {
    }

    public ResultSet queryDB(String query) {
        List<Object> results = new ArrayList<Object>();
        Connection conn = null;
        ResultSet rs;
        try {
            String url = "jdbc:sqlite:/Users/Nick/dev/pscasestudy/src/main/java/com/github/nhoffudel/PSVehDB.db";
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to DB");
            Statement stmt = null;
            try {
                stmt = conn.createStatement();
                rs = stmt.executeQuery(query);
            } catch (SQLException e) {
                throw new Error("Error querying", e);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }

        } catch (SQLException e) {
            throw new Error("Database error", e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return rs;
    }
}
