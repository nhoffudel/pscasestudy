package com.github.nhoffudel.service;

import com.github.nhoffudel.SQLiteDBConnection;
import com.github.nhoffudel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final SQLiteDBConnection dbc;

    public UserService(SQLiteDBConnection dbc) {
        this.dbc = dbc;
    }

    public UserService() {
        this(SQLiteDBConnection.VMS_USERS);
    }

    public User create(User user){    
        dbc.executeStatement("INSERT into Users (username, firstName, lastName, hashedPassword, securityQuestion, hashedSecurityAnswer) " +
                "VALUES ('" + user.getUsername()
                + "', '" + user.getFirstName()
                + "', '" + user.getLastName()
                + "', '" + user.getHashedPassword()
                + "', '" + user.getSecurityQuestion()
                + "', '" + user.getHashedSecurityAnswer() + "');");
        return read(user.getUsername());
    }

//    public User read(String username) {
//        ResultSet result = dbc.executeQuery("SELECT * FROM Users where username = '" + "';");
//        User user = new User();
//        try {
//            while (result.next()) {
//                user.setUsername(result.getString("username"));
//                user.setFirstName(result.getString("firstName"));
//                user.setLastName(result.getString("lastName"));
//                user.setHashedPassword(result.getString("hashedPassword"));
//                user.setSecurityQuestion(result.getString("securityQuestion"));
//                user.setHashedSecurityAnswer(result.getString("hashedSecurityAnswer"));
//                return user;
//            }
//        } catch (SQLException se) {
//            throw new Error(se);
//        }
//        return user;
//    }

    public User read(String username) {
        ResultSet result = dbc.executeQuery("SELECT * FROM Users;");
        User user = new User();
        try {
            while (result.next()) {
                if (result.getString("username").equals(username)) {
                    user.setUsername(result.getString("username"));
                    user.setFirstName(result.getString("firstName"));
                    user.setLastName(result.getString("lastName"));
                    user.setHashedPassword(result.getString("hashedPassword"));
                    user.setSecurityQuestion(result.getString("securityQuestion"));
                    user.setHashedSecurityAnswer(result.getString("hashedSecurityAnswer"));
                    return user;
                }
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return user;
    }

    public User update(String username, User user) {
        dbc.executeStatement("UPDATE Users SET hashedPassword = '" + user.getHashedPassword() +
                "', firstName = '" + user.getFirstName() +
                "', lastName = '" + user.getLastName() +
                "' where userName = '" + user.getUsername() + "';");
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
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String hashedPassword = result.getString("hashedPassword");
                String securityQuestion = result.getString("securityQuestion");
                String hashedSecurityAnswer = result.getString("hashedSecurityAnswer");
                User user = new User(username, firstName, lastName, hashedPassword, securityQuestion, hashedSecurityAnswer);
                list.add(user);
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return list;
    }

    public Boolean validateUser(String userName, String userPassword) {
        ResultSet result = dbc.executeQuery("SELECT * FROM Users where username = '" + userName + "';");
        try {
            while (result.next()) {
                if (result.getString("hashedPassword").equals(userPassword)) return true;
            }
        } catch (SQLException se) {
            throw new Error(se);
        }
        return false;
    }

    public User login(User user) {
        List<User> list = readAll();
        for (User u : list){
            if (u.getUsername().equals(user.getUsername()) &&
                    u.getHashedPassword().equals(user.getHashedPassword())) return u;
        }
        return null;
    }

    public boolean contains(String username){
        List<User> list = readAll();
        for (User u : list){
            if (u.getUsername().equals(username)) return true;
        }
        return false;
    }

    public String hashPass(String password){
        return password; //does nothing for testing purposes
    }
}