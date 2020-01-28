package com.github.nhoffudel.controller;

import com.github.nhoffudel.model.User;
import com.github.nhoffudel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/user-controller")
@RestController
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

//    @RequestMapping(value = "/create-default", method = RequestMethod.POST)
//    public ResponseEntity<User> create() {
//        User responseBody = service.create(new User(0L, "Leon", "Hunter"));
//        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
//        return responseEntity;
//    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user) {
        User responseBody = service.create(user);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public ResponseEntity<User> read(@PathVariable Long id) {
        User responseBody = service.read(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        User responseBody = service.update(id, user);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> delete(@PathVariable Long id) {
        User responseBody = service.delete(id);
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


    @RequestMapping(value = "/read-all", method = RequestMethod.GET)
    public ResponseEntity<List<User>> readAll() {
        List<User> responseBody = service.readAll();
        ResponseEntity responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        return responseEntity;
    }


}
