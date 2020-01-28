package com.github.nhoffudel.service;

import com.github.nhoffudel.model.User;
import com.github.nhoffudel.repository.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserHandler handler;

    @Autowired
    public UserService(UserHandler handler) {
        this.handler = handler;
    }

    public User create(User user) {
        return handler.create(user);
    }

    public User read(Long id) {
        return handler.findById(id);
    }

    public User update(Long id, User user) {
        User userInDataBase = read(id);
        String newpass = user.getHashedpassword();
        String newanswer = user.getHashedsecurityanswer();
        userInDataBase.setHashedpassword(newpass);
        userInDataBase.setHashedsecurityanswer(newanswer);
        handler.update(userInDataBase);
        return userInDataBase;
    }

    public User delete(Long id) {
        User user = read(id);
        handler.delete(user);
        return user;
    }

    public List<User> readAll() {
        return handler.findAll();
    }
}
