package com.github.nhoffudel.controller;

import com.github.nhoffudel.model.Vehicle;
import com.github.nhoffudel.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/vehicle-controller")
@RestController
public class VehicleController {
    private VehicleService service;

    @Autowired
    public VehicleController(VehicleService service) {
        this.service = service;
    }

//    @RequestMapping(value = "/create-default", method = RequestMethod.POST)
//    public ResponseEntity<Vehicle> create() {
//        Vehicle responseBody = service.create(new Vehicle(0L, "Leon", "Hunter"));
//        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
//        return responseEntity;
//    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle) {
        Vehicle responseBody = service.create(vehicle);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseEntity<Vehicle> read(@PathVariable String VIN) {
        Vehicle responseBody = service.read(VIN);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Vehicle> update(@PathVariable String VIN, @RequestBody Vehicle vehicle) {
        Vehicle responseBody = service.update(VIN, vehicle);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Vehicle> delete(@PathVariable String VIN) {
        Vehicle responseBody = service.delete(VIN);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read-all", method = RequestMethod.GET)
    public ResponseEntity<List<Vehicle>> readAll() {
        List<Vehicle> responseBody = service.readAll();
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


}
