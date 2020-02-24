package com.github.nhoffudel.controller;

import com.github.nhoffudel.model.Trip;
import com.github.nhoffudel.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/trip-controller")
@RestController
public class TripController {
    private TripService service;

    @Autowired
    public TripController(TripService service) {
        this.service = service;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Trip> create(@RequestBody Trip trip) {
        Trip responseBody = service.create(trip);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseEntity<Trip> read(@PathVariable Long id) {
        Trip responseBody = service.read(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Trip> update(@PathVariable Long id, @RequestBody Trip trip) {
        Trip responseBody = service.update(id, trip);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Trip> delete(@PathVariable Long id) {
        Trip responseBody = service.delete(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read-all", method = RequestMethod.GET)
    public ResponseEntity<List<Trip>> readAll() {
        List<Trip> responseBody = service.readAll();
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


}
