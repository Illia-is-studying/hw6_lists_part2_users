package com.example.hw6_lists_part2_users.Models;

public class Country {
    private String name;
    private String[] cities;

    public Country(String name, String[] cities) {
        this.name = name;
        this.cities = cities;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCities() {
        return cities;
    }

    public void setCities(String[] cities) {
        this.cities = cities;
    }
}
