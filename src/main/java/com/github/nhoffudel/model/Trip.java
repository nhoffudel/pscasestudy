package com.github.nhoffudel.model;

import javax.persistence.*;
@Entity
@Table(name = "Trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tripID")
    private Long id;
    @Column(name = "owner")
    private String owner;
    @Column(name = "vehicleName")
    private String vehicleName;
    @Column(name = "dateBegin")
    private int dateBegin;
    @Column(name = "dateEnd")
    private int dateEnd;
    @Column(name = "placeBegin")
    private String placeBegin;
    @Column(name = "placeEnd")
    private String placeEnd;
    @Column(name = "milesBegin")
    private double milesBegin;
    @Column(name = "milesEnd")
    private double milesEnd;
    @Column(name = "cost")
    private double cost;
    @Column(name = "fuelEcon")
    private double fuelEcon;
    @Column(name = "notes")
    private String notes;

    public Trip() {
        this.id = -1L;
    }

    public Trip(Long id, String owner, String vehicleName, int dateBegin, int dateEnd,
                String placeBegin, String placeEnd, double milesBegin, double milesEnd,
                double cost, double fuelEcon, String notes) {
        this.id = id;
        this.owner = owner;
        this.vehicleName = vehicleName;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.placeBegin = placeBegin;
        this.placeEnd = placeEnd;
        this.milesBegin = milesBegin;
        this.milesEnd = milesEnd;
        this.cost = cost;
        this.fuelEcon = fuelEcon;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(int dateBegin) {
        this.dateBegin = dateBegin;
    }

    public int getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(int dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getPlaceBegin() {
        return placeBegin;
    }

    public void setPlaceBegin(String placeBegin) {
        this.placeBegin = placeBegin;
    }

    public String getPlaceEnd() {
        return placeEnd;
    }

    public void setPlaceEnd(String placeEnd) {
        this.placeEnd = placeEnd;
    }

    public double getMilesBegin() {
        return milesBegin;
    }

    public void setMilesBegin(double milesBegin) {
        this.milesBegin = milesBegin;
    }

    public double getMilesEnd() {
        return milesEnd;
    }

    public void setMilesEnd(double milesEnd) {
        this.milesEnd = milesEnd;
    }

    public double getFuelEcon() {
        return fuelEcon;
    }

    public void setFuelEcon(double fuelEcon) {
        this.fuelEcon = fuelEcon;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName){
        this.vehicleName = vehicleName;
    }
}
