package com.springboot.bean;

public class Country {

    private String name;
    private int population;

    public Country() {
    }

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }
    //method gets the name
    public String getName() {
        return name;
    }
    //method gets the population
    public int getPopulation() {
        return population;
    }
    //method sets the population
    public void setPopulation(int population) {
        this.population = population;
    }
}
