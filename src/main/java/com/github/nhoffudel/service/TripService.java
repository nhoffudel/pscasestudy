package com.github.nhoffudel.service;

import com.github.nhoffudel.model.Trip;
import com.github.nhoffudel.repository.TripHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    private TripHandler handler;

    @Autowired
    public TripService(TripHandler handler) {
        this.handler = handler;
    }

    public Trip create(Trip trip) {
        return handler.create(trip);
    }

    public Trip read(Long id) {
        return handler.findById(id);
    }

    public Trip update(Long id, Trip trip) {
        Trip tripInDataBase = read(id);
        String newNotes = trip.getNotes();
        tripInDataBase.setNotes(newNotes);
        handler.update(tripInDataBase);
        return tripInDataBase;
    }

    public Trip delete(Long id) {
        Trip trip = read(id);
        handler.delete(trip);
        return trip;
    }

    public List<Trip> readAll() {
        return handler.findAll();
    }
}
