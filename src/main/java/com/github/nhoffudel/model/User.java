package com.github.nhoffudel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String username;
    String hashedpassword;
    String securityquestion;
    String hashedsecurityanswer;

    public User(){
    }

    public User(long id, String username, String hashedpassword, String securityquestion, String hashedsecurityanswer){
        this.id = id;
        this.username = username;
        this.hashedpassword = hashedpassword;
        this.securityquestion = securityquestion;
        this.hashedsecurityanswer = hashedsecurityanswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedpassword() {
        return hashedpassword;
    }

    public void setHashedpassword(String hashedpassword) {
        this.hashedpassword = hashedpassword;
    }

    public String getSecurityquestion() {
        return securityquestion;
    }

    public void setSecurityquestion(String securityquestion) {
        this.securityquestion = securityquestion;
    }

    public String getHashedsecurityanswer() {
        return hashedsecurityanswer;
    }

    public void setHashedsecurityanswer(String hashedsecurityanswer) {
        this.hashedsecurityanswer = hashedsecurityanswer;
    }
}
