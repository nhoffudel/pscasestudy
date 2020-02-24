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
        long newID = getMaxID() + 1;
        dbc.executeStatement("INSERT into Vehicles(ID, VIN, name, make, model, year, " +
                "color, engine, trim, notes, owner) VALUES(" + newID
                + ", '" + vehicle.getVIN()
                + "', '" + vehicle.getName()
                + "', '" + vehicle.getMake()
                + "', '" + vehicle.getModel()
                + "', " + vehicle.getYear()
                + ", '" + vehicle.getColor()
                + "', '" + vehicle.getEngine()
                + "', '" + vehicle.getTrim()
                + "', '" + vehicle.getNotes()
                + "', '" + vehicle.getOwner() + "';");
        return read(newID);
    }

    private long getMaxID() {
        ResultSet result = dbc.executeQuery("SELECT MAX(id) as 'max' from Vehicles;");
        long max = 0;
        try {
            while (result.next()) {
                max = result.getLong("max");
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return max;
    }

    public Vehicle read(long id) {
        ResultSet result = dbc.executeQuery("SELECT * FROM Vehicles where id = " + id + ";");
        Vehicle vehicle = new Vehicle();
        try {
            while (result.next()) {
                vehicle.setId(id);
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
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return vehicle;
    }

    public Vehicle update(Vehicle vehicle) {
        dbc.executeStatement("UPDATE Vehicles Set VIN = '" +  vehicle.getVIN()
                + "', make = '" + vehicle.getMake()
                + "', model = '" + vehicle.getModel()
                + "', year = " + vehicle.getYear()
                + ", color = '" + vehicle.getColor()
                + "', engine = '" + vehicle.getEngine()
                + "', trim = '" + vehicle.getTrim()
                + "', notes = '" + vehicle.getNotes()
                + "', owner = '" + vehicle.getOwner()
                + "' where id = " + vehicle.getId() + ";");
        return read(vehicle.getId());
    }

    public void delete(Long id) {
        dbc.executeStatement("Delete FROM Vehicles where id = " + id + ";");
    }

    public List<Vehicle> readAll() {
        ResultSet result = dbc.executeQuery("SELECT * FROM Vehicles");
        List<Vehicle> list = new ArrayList<>();
        try {
            while (result.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(result.getLong("id"));
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