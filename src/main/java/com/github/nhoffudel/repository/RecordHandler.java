package com.github.nhoffudel.repository;

import com.github.nhoffudel.model.Record;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordHandler {
    static DBHandler dbHandler;

    public RecordHandler() {
        dbHandler = new DBHandler();
    }

    public Record create(Record record) {
        String query = "Insert into Records (ServiceID, VehID, OwnerID, ServiceName, Date, Miles," +
                "Cost, Location, Notes) values (" +
                record.getId() + ", " + record.getVehID() + ", " +
                record.getOwnerID() + ", " +
                record.getName() + ", " + record.getDate() + ", " +
                record.getMiles() + ", " + record.getCost() + ", " +
                record.getLocation() + ", " + record.getNotes() + ");";
        dbHandler.queryDB(query);
        return record;
    }

    public Record findById(Long id) {
        ResultSet rs;
        String query = "Select * from Records where ServiceID = " + id + ";";
        rs = dbHandler.queryDB(query);
        try {
            if (rs.getLong("VehID") == id) {
                long VehID = rs.getLong("VehID");
                long OwnerID = rs.getLong("OwnerID");
                String name = rs.getString("ServiceName");
                int date = rs.getInt("Date");
                double miles = rs.getDouble("Miles");
                double cost = rs.getDouble("Cost");
                String location = rs.getString("Location");
                String notes = rs.getString("Notes");
                return new Record(id, VehID, OwnerID, name, date, miles, cost, location, notes);
            } else {
                return new Record();
            }
        } catch (SQLException e) {
            throw new Error("Find by ID error", e);
        }
    }

    public void update(Record record) {
        String query = "Update Records Set Notes = " + record.getNotes() +
                "' where ServiceID = " + record.getId() + ";";
        dbHandler.queryDB(query);
    }

    public void delete(Record record) {
        String query = "Delete from Records where VehID = " + record.getId() + ";";
        dbHandler.queryDB(query);
    }

    public List<Record> findAll() {
        List<Record> records = new ArrayList<>();
        String query = "Select * from Records;";
        ResultSet rs = dbHandler.queryDB(query);
        try {
            while (rs.next()) {
                Long ServiceID = rs.getLong("ServiceID");
                long VehID = rs.getLong("VehID");
                long OwnerID = rs.getLong("OwnerID");
                String name = rs.getString("ServiceName");
                int date = rs.getInt("Date");
                double miles = rs.getDouble("Miles");
                double cost = rs.getDouble("Cost");
                String location = rs.getString("Location");
                String notes = rs.getString("Notes");
                records.add(new Record(ServiceID, VehID, OwnerID, name, date, miles, cost, location, notes));
            }
        }
            catch (SQLException e){
                throw new Error("Find all error", e);
            }
        return records;
    }
}