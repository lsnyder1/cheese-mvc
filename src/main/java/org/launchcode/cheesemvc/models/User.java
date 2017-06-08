package org.launchcode.cheesemvc.models;

import java.util.Date;

/**
 * Created by lonny on 6/7/2017.
 */
public class User {
    private String username;
    private String email;
    private String password;
    private int id;
    private static int nextId = 1;
    private Date dateCreated = new Date();

    public User(String username, String email, String password, Date dateCreated) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;

        this.dateCreated = dateCreated;
        nextId ++;}

    public User(){
        id = nextId;
        nextId++;}


    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

