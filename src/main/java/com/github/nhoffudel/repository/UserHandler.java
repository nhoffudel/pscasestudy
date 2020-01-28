package com.github.nhoffudel.repository;

import com.github.nhoffudel.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserHandler {
    static DBHandler dbHandler;

    public UserHandler() {
        dbHandler = new DBHandler();
    }

    public User create(User user) {
        String query = "Insert into Users (UserID, UserName, UserPass, UserSecurityQ, UserSecurityA) values (" +
                user.getId() + ", " + user.getUsername() + ", " +
                user.getHashedpassword() +  ", " + user.getSecurityquestion() + ", " +
                user.getHashedsecurityanswer() + ");";
        dbHandler.queryDB(query);
        return user;
    }

    public User findById(Long id) {
        ResultSet rs;
        String query = "Select * from Users where UserID = " + id + ";";
        rs = dbHandler.queryDB(query);
        try {
            if (rs.getLong("UserID") == id) {
                String username = rs.getString("UserName");
                String password = rs.getString("UserPass");
                String question = rs.getString("UserSecurityQ");
                String answer = rs.getString("UserSecurityA");
                return new User(id, username, password, question, answer);
            } else {
                return new User();
            }
        } catch (SQLException e) {
            throw new Error("Find by ID error", e);
        }
    }

    public void update(User user) {
        String query = "Update Records Set Password = '" + user.getHashedpassword() +
                "', UserSecurityA = '" + user.getHashedsecurityanswer() +
                "' where UserID = " + user.getId() + ";";
        dbHandler.queryDB(query);
    }

    public void delete(User user) {
        String query = "Delete from Users where UserID = " + user.getId() + ";";
        dbHandler.queryDB(query);
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String query = "Select * from Users;";
        ResultSet rs = dbHandler.queryDB(query);
        try {
            while (rs.next()) {
                Long id = rs.getLong("UserID");
                String username = rs.getString("UserName");
                String password = rs.getString("UserPass");
                String question = rs.getString("UserSecurityQ");
                String answer = rs.getString("UserSecurityA");
                users.add(new User(id, username, password, question, answer));
            }
        } catch (SQLException e) {
            throw new Error("Find all error", e);
        }
        return users;
    }
}