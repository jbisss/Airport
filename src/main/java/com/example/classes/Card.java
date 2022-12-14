package com.example.classes;

public class Card {
    private int money;
    private int number;
    private int pinCode;

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

    public void addMoney(int money){
        this.money += money;
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

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
}
