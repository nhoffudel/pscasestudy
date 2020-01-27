package com.github.nhoffudel.service;

import com.github.nhoffudel.model.Vehicle;
import com.github.nhoffudel.repository.VehicleHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private VehicleHandler handler;

    @Autowired
    public VehicleService(VehicleHandler handler) {
        this.handler = handler;
    }

    public Vehicle create(Vehicle vehicle) {
        Vehicle vehicleCreated = handler.create(vehicle);
        return vehicleCreated;
    }

    public Vehicle read(Long id) {
        Optional<Vehicle> potentialVehicle = handler.findById(id);
        Vehicle vehicle = potentialVehicle.get();
        return vehicle;
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
        List<Vehicle> vehicleList = new ArrayList<>();
        handler.findAll().forEach(vehicleList::add);
        return vehicleList;
    }
}
