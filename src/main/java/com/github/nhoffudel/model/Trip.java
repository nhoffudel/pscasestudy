package com.github.nhoffudel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String owner;
    private String vehName;
    private int datebegin;
    private int dateend;
    private String placebegin;
    private String placeend;
    private double milesbegin;
    private double milesend;
    private double cost;
    private double fuelecon;
    private String notes;

    public Trip() {
        this.id = -1L;
    }

    public Trip(Long id, String owner, String vehName, int datebegin, int dateend,
                String placebegin, String placeend, double milesbegin, double milesend,
                double cost, double fuelecon, String notes) {
        this.id = id;
        this.owner = owner;
        this.vehName = vehName;
        this.datebegin = datebegin;
        this.dateend = dateend;
        this.placebegin = placebegin;
        this.placeend = placeend;
        this.milesbegin = milesbegin;
        this.milesend = milesend;
        this.cost = cost;
        this.fuelecon = fuelecon;
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

    public int getDatebegin() {
        return datebegin;
    }

    public void setDatebegin(int datebegin) {
        this.datebegin = datebegin;
    }

    public int getDateend() {
        return dateend;
    }

    public void setDateend(int dateend) {
        this.dateend = dateend;
    }

    public String getPlacebegin() {
        return placebegin;
    }

    public void setPlacebegin(String placebegin) {
        this.placebegin = placebegin;
    }

    public String getPlaceend() {
        return placeend;
    }

    public void setPlaceend(String placeend) {
        this.placeend = placeend;
    }

    public double getMilesbegin() {
        return milesbegin;
    }

    public void setMilesbegin(double milesbegin) {
        this.milesbegin = milesbegin;
    }

    public double getMilesend() {
        return milesend;
    }

    public void setMilesend(double milesend) {
        this.milesend = milesend;
    }

    public double getFuelecon() {
        return fuelecon;
    }

    public void setFuelecon(double fuelecon) {
        this.fuelecon = fuelecon;
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

    public String getVehName() {
        return vehName;
    }

    public void setVehName(String name){
        this.vehName = name;
    }
}
