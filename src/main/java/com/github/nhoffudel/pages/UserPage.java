package com.github.nhoffudel.pages;

import com.github.nhoffudel.SQLiteDBConnection;
import com.github.nhoffudel.model.User;
import com.github.nhoffudel.service.UserService;
import com.github.nhoffudel.utils.IOConsole;

public class UserPage {
    private static final IOConsole console = new IOConsole();
    private String username;

    public UserPage(String username){
        this.username = username;
    }

    public UserPage(){
    }

    public void changePassword() {
        UserService userService = new UserService(SQLiteDBConnection.VMS_USERS);
        User newUser = userService.read(username);
        String oldPass = console.getStringInput("Enter your old password");
        if (userService.validateUser(username, userService.hashPass(oldPass))) {
            String newPass1 = console.getStringInput("Enter your new password");
            String newPass2 = console.getStringInput("Confirm new password");
            if (newPass1.equals(newPass2)) {
                newUser.setHashedPassword(newPass1);
                userService.update(username, newUser);
                System.out.println("Password updated");
            }
            else System.out.println("Passwords do not match");
        }
        else System.out.println("Invalid password");
    }

    public void changeName() {
        UserService userService = new UserService(SQLiteDBConnection.VMS_USERS);
        User newUser = userService.read(username);
        newUser.setFirstName(console.getStringInput("Enter your new first name"));
        newUser.setLastName(console.getStringInput("Enter your new first name"));
        userService.update(username, newUser);
        System.out.println("Name updated");
    }

    public void register() {
        UserService userService = new UserService(SQLiteDBConnection.VMS_USERS);
        User newUser = new User();
        String username = console.getStringInput("Enter a username");
        if (!userService.contains(username)) {
            newUser.setUsername(username);
            newUser.setFirstName(console.getStringInput("Enter your first name"));
            newUser.setLastName(console.getStringInput("Enter your last name"));
            String newPass1 = console.getStringInput("Enter a password");
            String newPass2 = console.getStringInput("Confirm password");
            newUser.setSecurityQuestion(console.getStringInput("Enter a security question").replaceAll("'", "`"));
            newUser.setHashedSecurityAnswer(userService.hashPass(console.getStringInput(
                    "Enter the security question's answer")).replaceAll("'", "`"));
            if (newPass1.equals(newPass2)) {
                newUser.setHashedPassword(newPass1);
                userService.create(newUser);
                System.out.println("User created");
            }
            else System.out.println("Passwords do not match");
        }
        else System.out.println("User already exists");
    }

    public void forgotPassword() {
        UserService userService = new UserService(SQLiteDBConnection.VMS_USERS);
        String username = console.getStringInput("Enter your username");
        if (userService.contains(username)) {
            User newUser = userService.read(username);
            String answer = userService.hashPass(console.getStringInput("What is the answer to\n" +
                    newUser.getSecurityQuestion()));
            System.out.println(answer);
            System.out.println(newUser.getHashedSecurityAnswer());
            if (answer.equals(newUser.getHashedSecurityAnswer())) {
                String newPass1 = console.getStringInput("Enter your new password");
                String newPass2 = console.getStringInput("Confirm new password");
                if (newPass1.equals(newPass2)) {
                    newUser.setHashedPassword(newPass1);
                    userService.update(username, newUser);
                    System.out.println("Password updated");
                } else System.out.println("Passwords do not match");
            } else System.out.println("Answer does not match");
        }
        else System.out.println("User not found");
    }

    private void removeUser(String username) {
        UserService userService = new UserService(SQLiteDBConnection.VMS_USERS);
        userService.delete(username);
    }
}

