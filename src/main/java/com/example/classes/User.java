package com.example.classes;

import java.util.ArrayList;
import java.util.Random;

public class User {
    public static ArrayList<User> users = new ArrayList<>();
    public ArrayList<Flight> usersFlight = new ArrayList<>();
    public static User actualUser = null;
    private int passNumber;
    private int passSeries;
    public Card card = null;
    private String surname;
    private String name;
    private String middleName;
    private final String login;
    private final String password;
    public User(String login, String password, int cardNumber, int cardPin){
        this.card = new Card(10000, cardNumber, cardPin);
        this.login = login;
        this.password = password;
        users.add(this);
    }
    public User(String name, String surname, String middleName, String login, String password, int cardNumber, int cardPin){
        this(login, password, cardNumber, cardPin);
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        users.add(this);
    }
    public static User findUser(String login, String password){
        for (User user : users) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public String getLogin() {
        return login;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getPassNumber() {
        return passNumber;
    }

    public int getPassSeries() {
        return passSeries;
    }

    private String getPassword() {
        return password;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassNumber(int passNumber) {
        this.passNumber = passNumber;
    }

    public void setPassSeries(int passSeries) {
        this.passSeries = passSeries;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
