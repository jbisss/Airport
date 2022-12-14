package com.example.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Airport {
    public static ArrayList<Airport> airports = new ArrayList<>();
    public static ArrayList<String> cities = new ArrayList<>(Arrays.asList("Moscow", "Budapest",
            "Oslo", "Ottawa", "Prague", "Berlin", "Dublin", "London", "Tokyo"));
    public static ArrayList<String> names = new ArrayList<>(Arrays.asList("DOM", "SAL",
            "OSL", "OTT", "PRG", "RHG", "DUB", "LON", "TOK"));
    private String city;
    private String name;

    public void setCity(String city) {
        this.city = city;
    }

    public void setName(String name) {
        this.name = name;
    }

    static {
        String city;
        String cityAirport;
        for (int i = 0; i < 10; i ++){
            Random randDeparture = new Random();
            int size = Airport.cities.size();
            int departureNumber = randDeparture.nextInt(size);
            city = Airport.cities.get(departureNumber);
            cityAirport = Airport.names.get(departureNumber);
            if(!findAirport(city, cityAirport)){
                Airport.airports.add(new Airport(city, cityAirport));
            }
        }
    }
    public static boolean findAirport(String city, String name){
        for (Airport airport : airports) {
            if (airport.getName().equals(name) && airport.getCity().equals(city)) {
                return true;
            }
        }
        return false;
    }
    public Airport(String city, String name){
        this.city = city;
        this.name = name;
    }
    public static void foo(){};
    public String getCity() {
        return city;
    }
    public String getName() {
        return name;
    }

    public boolean compare(Airport anotherAirport) {
        return this.getCity().equals(anotherAirport.getCity()) && this.getName().equals(anotherAirport.getName());
    }
}
