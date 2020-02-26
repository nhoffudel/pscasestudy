package com.github.nhoffudel.model;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "hashedPassword")
    private String hashedPassword;
    @Column(name = "securityQuestion")
    private String securityQuestion;
    @Column(name = "hashedSecurityAnswer")
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
