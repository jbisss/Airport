package com.example.airport.classes;

public class Card {
    private int money;
    private final int number;
    private final int pinCode;

    public Card(int money, int number, int pinCode) {
        this.money = money;
        this.number = number;
        this.pinCode = pinCode;
    }

    public String decreaseMoney(int sum){
        if(sum > this.money) {
            return "Not enough money on card!";
        } else {
            this.money-=sum;
            return "Success";
        }
    }

    public int getMoney() {
        return money;
    }

    public int getNumber() {
        return number;
    }

    public int getPinCode() {
        return pinCode;
    }
}
