package com.github.nhoffudel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
    @Id
    private String vin;
    private String name;
    private String make;
    private String model;
    private int year;
    private String color;
    private String engine;
    private String trim;
    private String notes;
    private String owner;

    public Vehicle(){}

    public Vehicle(String vin, String name, String make, String model, int year, String color,
                   String engine, String trim, String notes, String owner) {
        this.vin = vin;
        this.name = name;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engine = engine;
        this.trim = trim;
        this.notes = notes;
        this.owner = owner;
    }

    public String getVIN() {
        return vin;
    }

    public void setVIN(String vin) {
        this.vin = vin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
