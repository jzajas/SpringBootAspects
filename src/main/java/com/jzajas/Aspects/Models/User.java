package com.jzajas.Aspects.Models;

import java.util.UUID;

public class User {

    private UUID ID;
    private String name;
    private String password;


    public User(UUID ID, String name, String password) {
        this.ID = ID;
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", password='" + password.hashCode() + '\'' +
                '}';
    }
}
