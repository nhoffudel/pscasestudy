package com.github.nhoffudel.model;

import javax.persistence.*;
@Entity
@Table(name = "Records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "vehicleVIN")
    private String vehicleVIN;
    @Column(name = "owner")
    private String owner;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private int date;
    @Column(name = "miles")
    private double miles;
    @Column(name = "cost")
    private double cost;
    @Column(name = "location")
    private String location;
    @Column(name = "notes")
    private String notes;

    public Record(){}

    public Record(Long id, String vehicleVIN, String owner, String name, int date,
                  double miles, double cost, String location, String notes) {
        this.id = id;
        this.vehicleVIN = vehicleVIN;
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

    public String getVehicleVIN() {
        return vehicleVIN;
    }

    public void setVehicleVIN(String vehicleVIN) {
        this.vehicleVIN = vehicleVIN;
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
