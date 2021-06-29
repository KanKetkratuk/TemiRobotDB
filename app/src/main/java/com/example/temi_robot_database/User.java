package com.example.temi_robot_database;

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class User implements Serializable
{
    @Exclude
    private String key;
    private String Username;
    private String Password;
    public User(){}
    public User(String Username, String Password)
    {
        this.Username = Username;
        this.Password = Password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
