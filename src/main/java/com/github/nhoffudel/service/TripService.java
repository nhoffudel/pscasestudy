package com.github.nhoffudel.service;

import com.github.nhoffudel.SQLiteDBConnection;
import com.github.nhoffudel.model.Trip;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TripService {
    private final SQLiteDBConnection dbc;

    public TripService(SQLiteDBConnection dbc) {
        this.dbc = dbc;
    }

    public TripService() {
        this(SQLiteDBConnection.VMS_TRIPS);
    }

    public Trip create(Trip trip) {
        long newtripID = getMaxtripID() + 1;
        dbc.executeStatement("INSERT into Trips (tripID, vehicleName, owner, dateBegin, dateEnd, " +
                "placeBegin, placeEnd, milesBegin, milesEnd, cost, fuelEcon, notes) VALUES (" + newtripID
                + ", '" + trip.getVehicleName()
                + "', '" + trip.getOwner()
                + "', " + trip.getDateBegin()
                + ", " + trip.getDateEnd()
                + ", '" + trip.getPlaceBegin()
                + "', '" + trip.getPlaceEnd()
                + "', " + trip.getMilesBegin()
                + ", " + trip.getMilesEnd()
                + ", " + trip.getCost()
                + ", " + trip.getFuelEcon()
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
                    trip.setVehicleName(result.getString("vehicleName"));
                    trip.setOwner(result.getString("owner"));
                    trip.setDateBegin(result.getInt("dateBegin"));
                    trip.setDateEnd(result.getInt("dateEnd"));
                    trip.setPlaceBegin(result.getString("placeBegin"));
                    trip.setPlaceEnd(result.getString("placeEnd"));
                    trip.setMilesBegin(result.getDouble("milesBegin"));
                    trip.setMilesEnd(result.getDouble("milesEnd"));
                    trip.setCost(result.getDouble("cost"));
                    trip.setFuelEcon(result.getDouble("fuelEcon"));
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
        dbc.executeStatement("UPDATE Trips Set vehicleName = '" + trip.getVehicleName()
                + "', owner = '" + trip.getOwner()
                + "', dateBegin = " + trip.getDateBegin()
                + ", dateEnd = " + trip.getDateEnd()
                + ", placeBegin = '" + trip.getPlaceBegin()
                + "', placeEnd = '" + trip.getPlaceEnd()
                + "', milesBegin = " + trip.getMilesBegin()
                + ", milesEnd = " + trip.getMilesEnd()
                + ", cost = " + trip.getCost()
                + ", fuelEcon = " + trip.getFuelEcon()
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
                trip.setVehicleName(result.getString("vehicleName"));
                trip.setOwner(result.getString("owner"));
                trip.setDateBegin(result.getInt("dateBegin"));
                trip.setDateEnd(result.getInt("dateEnd"));
                trip.setPlaceBegin(result.getString("placeBegin"));
                trip.setPlaceEnd(result.getString("placeEnd"));
                trip.setMilesBegin(result.getDouble("milesBegin"));
                trip.setMilesEnd(result.getDouble("milesEnd"));
                trip.setCost(result.getDouble("cost"));
                trip.setFuelEcon(result.getDouble("fuelEcon"));
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
                    trip.setVehicleName(result.getString("vehicleName"));
                    trip.setOwner(result.getString("owner"));
                    trip.setDateBegin(result.getInt("dateBegin"));
                    trip.setDateEnd(result.getInt("dateEnd"));
                    trip.setPlaceBegin(result.getString("placeBegin"));
                    trip.setPlaceEnd(result.getString("placeEnd"));
                    trip.setMilesBegin(result.getDouble("milesBegin"));
                    trip.setMilesEnd(result.getDouble("milesEnd"));
                    trip.setCost(result.getDouble("cost"));
                    trip.setFuelEcon(result.getDouble("fuelEcon"));
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