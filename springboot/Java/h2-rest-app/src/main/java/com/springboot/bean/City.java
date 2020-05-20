package com.springboot.bean;
//City class
public class City {

    private Long id;
    private String name;
    private int population;

    public City() {
    }

    public City(Long id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public Long getId() {
        return id;
    }
//sets Id
    public void setId(Long id) {
        this.id = id;
    }
//gets name and returns name
    public String getName() {
        return name;
    }
//sets name
    public void setName(String name) {
        this.name = name;
    }
//gets population and returns it
    public int getPopulation() {
        return population;
    }
//sets population
    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", name=" + name +
                ", population=" + population + '}';
    }
}
