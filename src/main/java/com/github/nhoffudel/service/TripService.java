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

    public Trip create(Trip trip){
        long newID = getMaxID() + 1;
        dbc.executeStatement("INSERT into Trips(ID, vehicleID, owner, dateBegin, dateEnd, " +
                "placeBegin, placeEnd, milesBegin, milesEnd, cost, fuelEcon, notes) VALUES(" + newID
                + ", " + trip.getVehID()
                + ", '" + trip.getOwner()
                + "', " + trip.getDatebegin()
                + ", " + trip.getDateend()
                + ", '" + trip.getPlacebegin()
                + "', '" + trip.getPlaceend()
                + "', " + trip.getMilesbegin()
                + ", " + trip.getMilesend()
                + ", " + trip.getCost()
                + ", " + trip.getFuelecon()
                + ", '" + trip.getNotes() + "';");
        return read(newID);
    }

    private long getMaxID() {
        ResultSet result = dbc.executeQuery("SELECT MAX(id) as 'max' from Trips;");
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
        ResultSet result = dbc.executeQuery("SELECT * FROM Trips where id = " + id + ";");
        Trip trip = new Trip();
        try {
            while (result.next()) {
                trip.setId(id);
                trip.setVehID(result.getLong("vehicleID"));
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
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return trip;
    }

    public Trip update(Long id, Trip trip) {
        dbc.executeStatement("UPDATE Trips Set vehicleID = " +  trip.getVehID()
                + ", owner = '" + trip.getOwner()
                + "', dateBegin = " + trip.getDatebegin()
                + ", dateEnd = " + trip.getDateend()
                + ", placeBegin = '" + trip.getPlacebegin()
                + "', placeEnd = '" + trip.getPlaceend()
                + "', milesBegin = " + trip.getMilesbegin()
                + ", milesEnd = " + trip.getMilesend()
                + ", cost = " + trip.getCost()
                + ", notes = '" + trip.getNotes()
                + "' where id = " + id + ";");
        return read(trip.getId());
    }

    public Trip delete(Long id) {
        Trip trip = read(id);
        dbc.executeStatement("Delete FROM Trips where id = " + id + ";");
        return trip;
    }

    public List<Trip> readAll() {
        ResultSet result = dbc.executeQuery("SELECT * FROM Trips");
        List<Trip> list = new ArrayList<>();
        try {
            while (result.next()) {
                Trip trip = new Trip();
                trip.setId(result.getLong("id"));
                trip.setVehID(result.getLong("vehicleID"));
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
}