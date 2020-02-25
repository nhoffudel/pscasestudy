package com.github.nhoffudel.service;

import com.github.nhoffudel.DatabaseConnection;
import com.github.nhoffudel.model.Vehicle;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    private final DatabaseConnection dbc;

    public VehicleService(DatabaseConnection dbc) {
        this.dbc = dbc;
    }

    public VehicleService() {
        this(DatabaseConnection.VEHICLE_MANAGEMENT_SYSTEM);
    }

    public Vehicle create(Vehicle vehicle){
        dbc.executeStatement("INSERT into Vehicles (VIN, name, make, model, year, " +
                "color, engine, trim, notes, owner) VALUES ('"
                + vehicle.getVIN()
                + "', '" + vehicle.getName()
                + "', '" + vehicle.getMake()
                + "', '" + vehicle.getModel()
                + "', " + vehicle.getYear()
                + ", '" + vehicle.getColor()
                + "', '" + vehicle.getEngine()
                + "', '" + vehicle.getTrim()
                + "', '" + vehicle.getNotes()
                + "', '" + vehicle.getOwner() + "');");
        return read(vehicle.getVIN());
    }

    public Vehicle read(String vin) {
        ResultSet result = dbc.executeQuery("SELECT * FROM Vehicles;");
        Vehicle vehicle = new Vehicle();
        try {
            while (result.next()) {
                if (result.getString("VIN").equals(vin)) {
                    vehicle.setVIN(result.getString("VIN"));
                    vehicle.setName(result.getString("name"));
                    vehicle.setMake(result.getString("make"));
                    vehicle.setModel(result.getString("model"));
                    vehicle.setYear(result.getInt("year"));
                    vehicle.setColor(result.getString("color"));
                    vehicle.setEngine(result.getString("engine"));
                    vehicle.setTrim(result.getString("trim"));
                    vehicle.setNotes(result.getString("notes"));
                    vehicle.setOwner(result.getString("owner"));
                    return vehicle;
                }
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return vehicle;
    }

    public Vehicle update(Vehicle vehicle) {
        return update(vehicle.getVIN(), vehicle);
    }

    public Vehicle update(String VIN, Vehicle vehicle) {
        dbc.executeStatement("UPDATE Vehicles Set name = '" + vehicle.getName()
                + "', make = '" + vehicle.getMake()
                + "', model = '" + vehicle.getModel()
                + "', year = " + vehicle.getYear()
                + ", color = '" + vehicle.getColor()
                + "', engine = '" + vehicle.getEngine()
                + "', trim = '" + vehicle.getTrim()
                + "', notes = '" + vehicle.getNotes()
                + "', owner = '" + vehicle.getOwner()
                + "' where VIN = " + VIN + ";");
        return read(vehicle.getVIN());
    }

    public Vehicle delete(String vin) {
        Vehicle vehicle = read(vin);
        dbc.executeStatement("Delete FROM Vehicles where VIN = " + vin + ";");
        return vehicle;
    }

    public List<Vehicle> readAll() {
        ResultSet result = dbc.executeQuery("SELECT * FROM Vehicles");
        List<Vehicle> list = new ArrayList<>();
        try {
            while (result.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVIN(result.getString("VIN"));
                vehicle.setName(result.getString("name"));
                vehicle.setMake(result.getString("make"));
                vehicle.setModel(result.getString("model"));
                vehicle.setYear(result.getInt("year"));
                vehicle.setColor(result.getString("color"));
                vehicle.setEngine(result.getString("engine"));
                vehicle.setTrim(result.getString("trim"));
                vehicle.setNotes(result.getString("notes"));
                vehicle.setOwner(result.getString("owner"));
                list.add(vehicle);
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return list;
    }

    public List<Vehicle> findByOwner(String username) {
        ResultSet result = dbc.executeQuery("SELECT * FROM Vehicles where owner = '" + username + "';");
        List<Vehicle> list = new ArrayList<>();
        try {
            while (result.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVIN(result.getString("VIN"));
                vehicle.setName(result.getString("name"));
                vehicle.setMake(result.getString("make"));
                vehicle.setModel(result.getString("model"));
                vehicle.setYear(result.getInt("year"));
                vehicle.setColor(result.getString("color"));
                vehicle.setEngine(result.getString("engine"));
                vehicle.setTrim(result.getString("trim"));
                vehicle.setNotes(result.getString("notes"));
                vehicle.setOwner(result.getString("owner"));
                list.add(vehicle);
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return list;
    }
}