package com.github.nhoffudel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String username;
    private String firstName;
    private String lastName;
    private String hashedPassword;
    private String securityQuestion;
    private String hashedSecurityAnswer;

    public User(){
    }

    public User(String username, String firstName, String lastName, String hashedPassword, String securityQuestion, String hashedSecurityAnswer){
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hashedPassword = hashedPassword;
        this.securityQuestion = securityQuestion;
        this.hashedSecurityAnswer = hashedSecurityAnswer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getHashedSecurityAnswer() {
        return hashedSecurityAnswer;
    }

    public void setHashedSecurityAnswer(String hashedSecurityAnswer) {
        this.hashedSecurityAnswer = hashedSecurityAnswer;
    }

}
