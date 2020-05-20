package com.springboot.bean;

public class User {

    private String name;
    private String occupation;
//gets name and returns it
    public String getName() {
        return name;
    }
//sets name
    public void setName(String name) {
        this.name = name;
    }
//gets occupation and returns it
    public String getOccupation() {
        return occupation;
    }
//sets occupation
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
