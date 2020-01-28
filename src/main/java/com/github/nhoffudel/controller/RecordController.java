package com.github.nhoffudel.controller;

import com.github.nhoffudel.model.Record;
import com.github.nhoffudel.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/record-controller")
@RestController
public class RecordController {
    private RecordService service;

    @Autowired
    public RecordController(RecordService service) {
        this.service = service;
    }

//    @RequestMapping(value = "/create-default", method = RequestMethod.POST)
//    public ResponseEntity<Record> create() {
//        Record responseBody = service.create(new Record(0L, "Leon", "Hunter"));
//        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
//        return responseEntity;
//    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Record> create(@RequestBody Record record) {
        Record responseBody = service.create(record);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseEntity<Record> read(@PathVariable Long id) {
        Record responseBody = service.read(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<Record> update(@PathVariable Long id, @RequestBody Record record) {
        Record responseBody = service.update(id, record);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Record> delete(@PathVariable Long id) {
        Record responseBody = service.delete(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read-all", method = RequestMethod.GET)
    public ResponseEntity<List<Record>> readAll() {
        List<Record> responseBody = service.readAll();
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


}
