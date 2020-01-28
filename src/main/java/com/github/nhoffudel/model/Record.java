package com.github.nhoffudel.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long vehID;
    Long ownerID;
    String name;
    int date;
    double miles;
    double cost;
    String location;
    String notes;

    public Record() {
        this.id = -1L;
    }

    public Record(Long id, Long vehID, Long ownerID, String name, int date,
                  double miles, double cost, String location, String notes) {
        this.id = id;
        this.vehID = vehID;
        this.ownerID = ownerID;
        this.name = name;
        this.date = date;
        this.miles = miles;
        this.cost = cost;
        this.location = location;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehID() {
        return vehID;
    }

    public void setVehID(Long vehID) {
        this.vehID = vehID;
    }

    public Long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Long ownerID) {
        this.ownerID = ownerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
