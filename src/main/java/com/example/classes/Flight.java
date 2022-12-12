package com.example.classes;

import java.util.ArrayList;

public class Flight {
    public static ArrayList<Flight> flights = new ArrayList<>();
    private static int count;
    private final int id;
    public Airport departure;
    public Airport destination;
    private String departureTime;
    private String destinationTime;
    private String date;
    private boolean serviceClass;
    private int seatsNumber;
    public Flight(Airport departure, Airport destination, String date, String departureTime, String destinationTime,
                  boolean serviceClass, int seatsNumber){
        count++;
        this.id = count;
        this.departure = departure;
        this.destination = destination;
        this.date = date;
        this.departureTime = departureTime;
        this.destinationTime = destinationTime;
        this.serviceClass = serviceClass;
        this.seatsNumber = seatsNumber;
        flights.add(this);
    }

    public void setDeparture(Airport departure) {
        this.departure = departure;
    }
    public void setDestination(Airport destination) {
        this.destination = destination;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public void setDestinationTime(String destinationTime) {
        this.destinationTime = destinationTime;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setServiceClass(boolean serviceClass) {
        this.serviceClass = serviceClass;
    }
    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public int getId() {
        return id;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public String getDestinationTime() {
        return destinationTime;
    }
    public String getDate() {
        return date;
    }
    public boolean isServiceClass() {
        return serviceClass;
    }
    public int getSeatsNumber() {
        return seatsNumber;
    }
}
