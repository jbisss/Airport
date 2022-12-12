package com.example.classes;

public class Airport {
    private final String country;
    private final String name;
    public Airport(String country, String name){
        this.country = country;
        this.name = name;
    }

    public String getCountry() {
        return country;
    }
    public String getName() {
        return name;
    }
}
