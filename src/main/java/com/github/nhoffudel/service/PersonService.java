package com.github.nhoffudel.service;

import com.github.nhoffudel.DatabaseConnection;
import com.github.nhoffudel.model.Person;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private final DatabaseConnection dbc;

    public PersonService(DatabaseConnection dbc) {
        this.dbc = dbc;
    }

    public PersonService() {
        this(DatabaseConnection.VEHICLE_MANAGEMENT_SYSTEM);
    }

    public Person create(Person person) {
        dbc.executeStatement("INSERT into Person(username, firstName, lastName) VALUES("
                + person.getUsername()
                + "', '" + person.getFirstName()
                + "', '" + person.getLastName() + "';");
        return read(person.getUsername());
    }

    public Person read(String username) {
        ResultSet result = dbc.executeQuery("SELECT * FROM Person where username = " + ";");
        Person person = new Person();
        try {
            while (result.next()) {
                person.setUsername(result.getString("userName"));
                person.setFirstName(result.getString("firstName"));
                person.setLastName(result.getString("lastName"));
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return person;
    }

    public Person update(String username, Person person) {
        dbc.executeStatement("UPDATE Person SET firstName = '" + person.getFirstName()
                + "', lastName = '" + person.getLastName() + "' where userName = " + username + ";");
        return read(person.getUsername());
    }

    public Person delete(String username) {
        Person person = read(username);
        dbc.executeStatement("Delete FROM Person where username = '" + username + "';");
        return person;
    }

    public List<Person> readAll() {
            ResultSet result = dbc.executeQuery("SELECT * FROM Person");
            List<Person> list = new ArrayList<>();
            try {
                while (result.next()) {
                    String username = result.getString("username");
                    String firstName = result.getString("firstName");
                    String lastName = result.getString("lastName");
                    Person person = new Person(username, firstName, lastName);
                    list.add(person);
                }
            } catch (SQLException se) {
                throw new Error(se);
            }
            return list;
    }
}
