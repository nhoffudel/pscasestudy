package com.github.nhoffudel.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Long ownerID;
    Long vehID;
    Date datebegin;
    Date dateend;
    String placebegin;
    String placeend;
    double milesbegin;
    double milesend;
    double fuelecon;
    String notes;

    public Trip() {
    }

    public Trip(Long id, Long ownerID, Long vehID, Date datebegin, Date dateend,
                String placebegin, String placeend, double milesbegin, double milesend,
                double fuelecon, String notes) {
        this.id = id;
        this.ownerID = ownerID;
        this.vehID = vehID;
        this.datebegin = datebegin;
        this.dateend = dateend;
        this.placebegin = placebegin;
        this.placeend = placeend;
        this.milesbegin = milesbegin;
        this.milesend = milesend;
        this.fuelecon = fuelecon;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Long ownerID) {
        this.ownerID = ownerID;
    }

    public Long getVehID() {
        return vehID;
    }

    public void setVehID(Long vehID) {
        this.vehID = vehID;
    }

    public Date getDatebegin() {
        return datebegin;
    }

    public void setDatebegin(Date datebegin) {
        this.datebegin = datebegin;
    }

    public Date getDateend() {
        return dateend;
    }

    public void setDateend(Date dateend) {
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
}
