package org.launchcode.cheesemvc.models;

import java.util.Date;

/**
 * Created by lonny on 6/7/2017.
 */
public class User {
    private String userName;
    private String email;
    private String password;
    private int id;
    private static int nextId = 1;
    private Date dateCreated = new Date();

    public User(String userName, String email, String password, Date dateCreated) {
        this();
        this.userName = userName;
        this.email = email;
        this.password = password;

        this.dateCreated = dateCreated;
        nextId ++;}

    public User(){
        id = nextId;
        nextId++;}


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

