package com.github.nhoffudel.service;

import com.github.nhoffudel.DatabaseConnection;
import com.github.nhoffudel.model.Record;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecordService {
    private final DatabaseConnection dbc;

    public RecordService(DatabaseConnection dbc) {
        this.dbc = dbc;
    }

    public RecordService() {
        this(DatabaseConnection.VEHICLE_MANAGEMENT_SYSTEM);
    }

    public Record create(Record record){
        long newID = getMaxID() + 1;
        dbc.executeStatement("INSERT into Records(ID, vehicleID, owner, name, date, miles, cost, location, notes) " +
                "VALUES(" + newID
                + ", " + record.getVehID()
                + ", '" + record.getOwner()
                + "', '" + record.getName()
                + "', " + record.getDate()
                + ", " + record.getMiles()
                + ", " + record.getCost()
                + ", '" + record.getLocation()
                + "', '" + record.getNotes() + "';");
        return read(newID);
    }

    private long getMaxID() {
        ResultSet result = dbc.executeQuery("SELECT MAX(id) as 'max' from Records;");
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

    public Record read(long id) {
        ResultSet result = dbc.executeQuery("SELECT * FROM Records where id = " + id + ";");
        Record record = new Record();
        try {
            while (result.next()) {
                record.setId(id);
                record.setVehID(result.getLong("vehicleID"));
                record.setOwner(result.getString("owner"));
                record.setName(result.getString("name"));
                record.setDate(result.getInt("date"));
                record.setMiles(result.getDouble("miles"));
                record.setCost(result.getDouble("cost"));
                record.setLocation(result.getString("location"));
                record.setNotes(result.getString("notes"));
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return record;
    }

    public Record update(Long id, Record record) {
        dbc.executeStatement("UPDATE Records Set vehicleID = " +  record.getVehID()
                + ", owner = " + record.getOwner()
                + ", name = '" + record.getName()
                + "', date = " + record.getDate()
                + ", miles = " + record.getMiles()
                + ", cost = " + record.getCost()
                + ", location = '" + record.getLocation()
                + "', notes = '" + record.getNotes()
                + "' where id = " + id + ";");
        return read(record.getId());
    }

    public Record delete(Long id) {
        Record record = read(id);
        dbc.executeStatement("Delete FROM Records where id = " + id + ";");
        return record;
    }

    public List<Record> readAll() {
        ResultSet result = dbc.executeQuery("SELECT * FROM Records");
        List<Record> list = new ArrayList<>();
        try {
            while (result.next()) {
                Record record = new Record();
                record.setId(result.getLong("id"));
                record.setVehID(result.getLong("vehicleID"));
                record.setOwner(result.getString("owner"));
                record.setName(result.getString("name"));
                record.setDate(result.getInt("date"));
                record.setMiles(result.getDouble("miles"));
                record.setCost(result.getDouble("cost"));
                record.setLocation(result.getString("location"));
                record.setNotes(result.getString("notes"));
                list.add(record);
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return list;
    }
}