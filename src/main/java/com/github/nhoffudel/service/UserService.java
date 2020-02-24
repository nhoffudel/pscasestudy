package com.github.nhoffudel.service;

import com.github.nhoffudel.DatabaseConnection;
import com.github.nhoffudel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final DatabaseConnection dbc;

    public UserService(DatabaseConnection dbc) {
        this.dbc = dbc;
    }

    public UserService() {
        this(DatabaseConnection.VEHICLE_MANAGEMENT_SYSTEM);
    }

    public User create(User user){    
        dbc.executeStatement("INSERT into Users(username, hashedPassword, securityQuestion, hashedSecurityAnswer) " +
                "VALUES(" + user.getUsername()
                + "', '" + user.getHashedpassword() + "';"
                + "', '" + user.getSecurityquestion() + "';"
                + "', '" + user.getHashedsecurityanswer() + "';");
        return read(user.getUsername());
    }

    public User read(String username) {
        ResultSet result = dbc.executeQuery("SELECT * FROM Users where username = " + ";");
        User user = new User();
        try {
            while (result.next()) {
                user.setUsername(result.getString("username"));
                user.setHashedpassword(result.getString("hashedPassword"));
                user.setSecurityquestion(result.getString("securityQuestion"));
                user.setHashedsecurityanswer(result.getString("hashedSecurityAnswer"));
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return user;
    }

    public User update(String username, User user) {
        dbc.executeStatement("UPDATE Users SET hashedPassword = '" + user.getHashedpassword()
                + "' where userName = " + user.getUsername() + ";");
        return read(user.getUsername());
    }

    public User delete(String username) {
        User user = read(username);
        dbc.executeStatement("Delete FROM Users where username = '" + username + "';");
        return user;
    }

    public List<User> readAll() {
        ResultSet result = dbc.executeQuery("SELECT * FROM Users");
        List<User> list = new ArrayList<>();
        try {
            while (result.next()) {
                String username = result.getString("username");
                String hashedPassword = result.getString("hashedPassword");
                String securityQuestion = result.getString("securityQuestion");
                String hashedSecurityAnswer = result.getString("hashedSecurityAnswer");
                User user = new User(username, hashedPassword, securityQuestion, hashedSecurityAnswer);
                list.add(user);
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return list;
    }
}