package com.github.nhoffudel.repository;

import com.github.nhoffudel.model.Trip;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TripHandler {
    static DBHandler dbHandler;

    public TripHandler() {
        dbHandler = new DBHandler();
    }

    public Trip create(Trip trip) {
        String query = "Insert into Trips (TripID, VehID, OwnerID, DateBegin, DateEnd," +
                "PlaceBegin, PlaceEnd, MilesBegin, MilesEnd, FuelEcon, Notes) values (" +
                trip.getId() + ", " + trip.getVehID() + ", " +
                trip.getOwnerID() + ", " + trip.getDatebegin() + ", " +
                trip.getDateend() + ", " + trip.getPlacebegin() + ", " +
                trip.getPlaceend() + ", " + trip.getMilesbegin() + ", " +
                trip.getMilesend() + ", " + trip.getFuelecon() + ", " +
                trip.getOwnerID() + ");";
        dbHandler.queryDB(query);
        return trip;
    }

    public Trip findById(Long id) {
        ResultSet rs;
        String query = "Select * from Trips where TripID = " + id + ";";
        rs = dbHandler.queryDB(query);
        try {
            if (rs.getLong("TripID") == id) {
                Long ownerID = rs.getLong("OwnerID");
                Long vehID = rs.getLong("VehID");
                int datebegin = rs.getInt("DateBegin");
                int dateend = rs.getInt("DateEnd");
                String placebegin = rs.getString("PlaceBegin");
                String placeend = rs.getString("PlaceEnd");
                double milesbegin = rs.getDouble("MilesBegin");
                double milesend = rs.getDouble("MilesEnd");
                double fuelecon = rs.getDouble("FuelEcon");
                String notes = rs.getString("Notes");
                return new Trip(id, vehID, ownerID, datebegin, dateend,
                        placebegin, placeend, milesbegin, milesend, fuelecon, notes);
            } else {
                return new Trip();
            }
        } catch (SQLException e) {
            throw new Error("Find by ID error", e);
        }
    }

    public void update(Trip trip) {
        String query = "Update Records Set Notes = " + trip.getNotes() +
                "' where TripID = " + trip.getId() + ";";
        dbHandler.queryDB(query);
    }

    public void delete(Trip trip) {
        String query = "Delete from Trips where TripID = " + trip.getId() + ";";
        dbHandler.queryDB(query);
    }

    public List<Trip> findAll() {
        List<Trip> trips = new ArrayList<>();
        String query = "Select * from Trips;";
        ResultSet rs = dbHandler.queryDB(query);
        try {
            while (rs.next()) {
                Long id = rs.getLong("TripID");
                Long ownerID = rs.getLong("OwnerID");
                Long vehID = rs.getLong("VehID");
                int datebegin = rs.getInt("DateBegin");
                int dateend = rs.getInt("DateEnd");
                String placebegin = rs.getString("PlaceBegin");
                String placeend = rs.getString("PlaceEnd");
                double milesbegin = rs.getDouble("MilesBegin");
                double milesend = rs.getDouble("MilesEnd");
                double fuelecon = rs.getDouble("FuelEcon");
                String notes = rs.getString("Notes");
                trips.add(new Trip(id, vehID, ownerID, datebegin, dateend,
                        placebegin, placeend, milesbegin, milesend, fuelecon, notes));
            }
        } catch (SQLException e) {
            throw new Error("Find all error", e);
        }
        return trips;
    }
}