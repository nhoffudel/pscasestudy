package com.github.nhoffudel.repository;

import com.github.nhoffudel.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VehicleHandler {
    static DBHandler dbHandler;

    public VehicleHandler() {
        dbHandler = new DBHandler();
    }

    public Vehicle create(Vehicle vehicle) {
        String query = "Insert into Vehicles (VehID, VIN, Name, Make, Model," +
                "Year, Color, Engine, Trim, Notes, OwnerID) values (" +
                vehicle.getId() + ", " + vehicle.getVIN() + ", " +
                vehicle.getName() + ", " + vehicle.getMake() + ", " +
                vehicle.getModel() + ", " + vehicle.getYear() + ", " +
                vehicle.getColor() + ", " + vehicle.getEngine() + ", " +
                vehicle.getTrim() + ", " + vehicle.getNotes() + ", " +
                vehicle.getOwnerID() + ");";
        dbHandler.queryDB(query);
        return vehicle;
    }

    public Vehicle findById(Long id) {
        ResultSet rs;
        String query = "Select * from Vehicles where VehID = " + id + ";";
        rs = dbHandler.queryDB(query);
        try {
            if (rs.getLong("VehID") == id) {
                String vin = rs.getString("VIN");
                String name = rs.getString("Name");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                int year = rs.getInt("Year");
                String color = rs.getString("Color");
                String engine = rs.getString("Engine");
                String trim = rs.getString("Trim");
                String notes = rs.getString("Notes");
                Long ownerID = rs.getLong("OwnerID");
                return new Vehicle(id, vin, name, make, model, year, color, engine, trim, notes, ownerID);
            } else {
                return new Vehicle();
            }
        } catch (SQLException e) {
            throw new Error("Find by ID error", e);
        }
    }

    public void update(Vehicle vehicle) {
        String query = "Update Vehicles Set Color = '" + vehicle.getColor() + "', Engine = '" +
                vehicle.getEngine() + "', Trim = '" + vehicle.getTrim() + "', Notes = " + vehicle.getNotes() +
                "' where VehID = " + vehicle.getId() + ";";
        dbHandler.queryDB(query);
    }

    public void delete(Vehicle vehicle) {
        String query = "Delete from Vehicles where VehID = " + vehicle.getId() + ";";
        dbHandler.queryDB(query);
    }

    public List<Vehicle> findAll() {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "Select * from Vehicles;";
        ResultSet rs = dbHandler.queryDB(query);
        try {
            while (rs.next()) {
                Long id = rs.getLong("VehID");
                String vin = rs.getString("VIN");
                String name = rs.getString("Name");
                String make = rs.getString("Make");
                String model = rs.getString("Model");
                int year = rs.getInt("Year");
                String color = rs.getString("Color");
                String engine = rs.getString("Engine");
                String trim = rs.getString("Trim");
                String notes = rs.getString("Notes");
                Long ownerID = rs.getLong("OwnerID");
                vehicles.add(new Vehicle(id, vin, name, make, model, year, color, engine, trim, notes, ownerID));
            }
        }
            catch (SQLException e){
                throw new Error("Find all error", e);
            }
        return vehicles;
    }
}