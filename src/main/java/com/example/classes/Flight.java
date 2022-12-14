package com.example.classes;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class Flight {

    public static ArrayList<Flight> flights = new ArrayList<>();
    public static ArrayList<HBox> flightsHBox = new ArrayList<>();
    public static Flight flightToChange;
    public static Flight actualFlight;
    private static int count;
    private final int id;
    public Airport departure;
    public Airport destination;
    private String departureTime;
    private String destinationTime;
    private String date;
    private boolean serviceClass;
    private int seatsNumber;
    private int cost;
    public Button buttonRefund;
    private User owner;
    public HBox hBox = new HBox();
    public Flight(Airport departure, Airport destination, String date, String departureTime, String destinationTime,
                  boolean serviceClass, int seatsNumber, int cost, User owner){
        this(departure, destination, date, serviceClass, owner);
        flightsHBox.add(hBox);
        this.departure = departure;
        this.destination = destination;
        this.date = date;
        this.departureTime = departureTime;
        this.destinationTime = destinationTime;
        this.serviceClass = serviceClass;
        this.seatsNumber = seatsNumber;
        this.cost = cost;
    }
    public Flight(Airport departure, Airport destination, String date, boolean rate, User owner){
        count++;
        this.owner = owner;
        this.buttonRefund = new Button("Возврат");
        this.id = count;
        this.departure = departure;
        this.destination = destination;
        this.date = date;
        this.serviceClass = rate;
        this.buttonRefund.setOnAction(actionEvent -> {
            buttonRefund.setDisable(!(owner instanceof Admin));
            this.owner.card.addMoney(this.cost);
            this.owner.usersFlight.remove(this);
            Elements.vBox.getChildren().remove(hBox);
        });
        actualFlight = this;
    }

    public void setCost(int cost) {
        this.cost = cost;
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

    public void setOwner(User owner) {
        this.owner = owner;
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

    public int getCost() {
        return cost;
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
    public boolean getServiceClass() {
        return serviceClass;
    }
    public int getSeatsNumber() {
        return seatsNumber;
    }
    @Override
    public String toString(){
        return this.departure.getName() + " " + this.departure.getCity() + " - " + this.destination.getName()
                + " " + this.destination.getCity() + " " + this.date;
    }
}
