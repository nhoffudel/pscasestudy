package com.github.nhoffudel.service;

import com.github.nhoffudel.DatabaseConnection;
import com.github.nhoffudel.model.Trip;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {
    private final DatabaseConnection dbc;

    public TripService(DatabaseConnection dbc) {
        this.dbc = dbc;
    }

    public TripService() {
        this(DatabaseConnection.VEHICLE_MANAGEMENT_SYSTEM);
    }

    public Trip create(Trip trip) {
        long newtripID = getMaxtripID() + 1;
        dbc.executeStatement("INSERT into Trips (tripID, vehicleName, owner, dateBegin, dateEnd, " +
                "placeBegin, placeEnd, milesBegin, milesEnd, cost, fuelEcon, notes) VALUES (" + newtripID
                + ", '" + trip.getVehName()
                + "', '" + trip.getOwner()
                + "', " + trip.getDatebegin()
                + ", " + trip.getDateend()
                + ", '" + trip.getPlacebegin()
                + "', '" + trip.getPlaceend()
                + "', " + trip.getMilesbegin()
                + ", " + trip.getMilesend()
                + ", " + trip.getCost()
                + ", " + trip.getFuelecon()
                + ", '" + trip.getNotes() + "');");
        return read(newtripID);
    }

    private long getMaxtripID() {
        ResultSet result = dbc.executeQuery("SELECT MAX(tripID) as 'max' from Trips;");
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

    public Trip read(long id) {
        ResultSet result = dbc.executeQuery("SELECT * FROM Trips;");
        Trip trip = new Trip();
        try {
            while (result.next()) {
                if (result.getLong("tripID") == id) {
                    trip.setId(id);
                    trip.setVehName(result.getString("vehicleName"));
                    trip.setOwner(result.getString("owner"));
                    trip.setDatebegin(result.getInt("dateBegin"));
                    trip.setDateend(result.getInt("dateEnd"));
                    trip.setPlacebegin(result.getString("placeBegin"));
                    trip.setPlaceend(result.getString("placeEnd"));
                    trip.setMilesbegin(result.getDouble("milesBegin"));
                    trip.setMilesend(result.getDouble("milesEnd"));
                    trip.setCost(result.getDouble("cost"));
                    trip.setFuelecon(result.getDouble("fuelEcon"));
                    trip.setNotes(result.getString("notes"));
                    return trip;
                }
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return trip;
    }

    public Trip update(Long id, Trip trip) {
        dbc.executeStatement("UPDATE Trips Set vehicleName = '" + trip.getVehName()
                + "', owner = '" + trip.getOwner()
                + "', dateBegin = " + trip.getDatebegin()
                + ", dateEnd = " + trip.getDateend()
                + ", placeBegin = '" + trip.getPlacebegin()
                + "', placeEnd = '" + trip.getPlaceend()
                + "', milesBegin = " + trip.getMilesbegin()
                + ", milesEnd = " + trip.getMilesend()
                + ", cost = " + trip.getCost()
                + ", notes = '" + trip.getNotes()
                + "' where tripID = " + id + ";");
        return read(trip.getId());
    }

    public Trip delete(Long id) {
        Trip trip = read(id);
        dbc.executeStatement("Delete FROM Trips where tripID = " + id + ";");
        return trip;
    }

    public List<Trip> readAll() {
        ResultSet result = dbc.executeQuery("SELECT * FROM Trips");
        List<Trip> list = new ArrayList<>();
        try {
            while (result.next()) {
                Trip trip = new Trip();
                trip.setId(result.getLong("tripID"));
                trip.setVehName(result.getString("vehicleVIN"));
                trip.setOwner(result.getString("owner"));
                trip.setDatebegin(result.getInt("dateBegin"));
                trip.setDateend(result.getInt("dateEnd"));
                trip.setPlacebegin(result.getString("placeBegin"));
                trip.setPlaceend(result.getString("placeEnd"));
                trip.setMilesbegin(result.getDouble("milesBegin"));
                trip.setMilesend(result.getDouble("milesEnd"));
                trip.setCost(result.getDouble("cost"));
                trip.setFuelecon(result.getDouble("fuelEcon"));
                trip.setNotes(result.getString("notes"));
                list.add(trip);
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return list;
    }

    public List<Trip> findByOwner(String username) {
        ResultSet result = dbc.executeQuery("SELECT * FROM Trips;");
        List<Trip> list = new ArrayList<>();
        try {
            while (result.next()) {
                if (result.getString("owner").equals(username)) {
                    Trip trip = new Trip();
                    trip.setId(result.getLong("tripID"));
                    trip.setVehName(result.getString("vehicleName"));
                    trip.setOwner(result.getString("owner"));
                    trip.setDatebegin(result.getInt("dateBegin"));
                    trip.setDateend(result.getInt("dateEnd"));
                    trip.setPlacebegin(result.getString("placeBegin"));
                    trip.setPlaceend(result.getString("placeEnd"));
                    trip.setMilesbegin(result.getDouble("milesBegin"));
                    trip.setMilesend(result.getDouble("milesEnd"));
                    trip.setCost(result.getDouble("cost"));
                    trip.setFuelecon(result.getDouble("fuelEcon"));
                    trip.setNotes(result.getString("notes"));
                    list.add(trip);
                }
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return list;
    }
}