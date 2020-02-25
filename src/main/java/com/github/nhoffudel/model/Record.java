package com.github.nhoffudel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String vehVIN;
    private String owner;
    private String name;
    private int date;
    private double miles;
    private double cost;
    private String location;
    private String notes;

    public Record(){}

    public Record(Long id, String vehVIN, String owner, String name, int date,
                  double miles, double cost, String location, String notes) {
        this.id = id;
        this.vehVIN = vehVIN;
        this.owner = owner;
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

    public String getVehVIN() {
        return vehVIN;
    }

    public void setVehVIN(String vehVIN) {
        this.vehVIN = vehVIN;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
