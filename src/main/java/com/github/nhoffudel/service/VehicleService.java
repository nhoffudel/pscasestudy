package com.github.nhoffudel.service;

import com.github.nhoffudel.model.Vehicle;
import com.github.nhoffudel.repository.VehicleHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private VehicleHandler handler;

    @Autowired
    public VehicleService(VehicleHandler handler) {
        this.handler = handler;
    }

    public Vehicle create(Vehicle vehicle) {
        return handler.create(vehicle);
    }

    public Vehicle read(Long id) {
        return handler.findById(id);
    }

    public Vehicle update(Long id, Vehicle vehicle) {
        Vehicle vehicleInDataBase = read(id);
        String newColor = vehicle.getColor();
        String newEngine = vehicle.getEngine();
        String newTrim = vehicle.getTrim();
        String newNotes = vehicle.getNotes();

        vehicleInDataBase.setColor(newColor);
        vehicleInDataBase.setEngine(newEngine);
        vehicleInDataBase.setTrim(newTrim);
        vehicleInDataBase.setNotes(newNotes);

        handler.update(vehicleInDataBase);
        return vehicleInDataBase;
    }

    public Vehicle delete(Long id) {
        Vehicle vehicle = read(id);
        handler.delete(vehicle);
        return vehicle;
    }

    public List<Vehicle> readAll() {
        return handler.findAll();
    }
}
