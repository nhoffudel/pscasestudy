package com.github.nhoffudel.repository;

import com.github.nhoffudel.model.Vehicle;

import java.sql.*;
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

    public Optional<Vehicle> findById(Long id) {
        Vehicle foundveh = new Vehicle();
        String query = "
        foundveh = dbHandler.queryDB(query);
        return vehicle;
    }
}
