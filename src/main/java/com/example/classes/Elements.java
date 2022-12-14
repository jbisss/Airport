package com.example.classes;

import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Random;

public class Elements {
    public static VBox vBox;
    public static User adminMain;
    public static ArrayList<String> dates = new ArrayList<>();
    static {
        Airport.foo();
        User admin = new Admin("Admin", "Adminov", "Adminovich", "admin", "admin", 1, 1);
        User.users.add(admin);
        adminMain = admin;
        User user = new User("Лена", "Кузнецова", "Владиславовна", "lena","lena_super", 123456, 1234);
        int size = Airport.airports.size();
        Random rand = new Random();
        Airport air_1 = Airport.airports.get(rand.nextInt(size));
        Airport air_2 = Airport.airports.get(rand.nextInt(size));
        while (air_1.compare(air_2)){
            air_1 = Airport.airports.get(rand.nextInt(size));
            air_2 = Airport.airports.get(rand.nextInt(size));
        }
        user.usersFlight.add(new Flight(air_1, air_2, "18.12.22", "10:00", "18:00",
                true, 100, 1000, user));
        user.usersFlight.add(new Flight(air_1, air_2, "18.12.22", "10:00", "18:00",
                true, 100, 1000, user));
        // Creating flights
        Random randF = new Random();
        for (int i = 0; i < 100;i++){
            int ch = randF.nextInt(31) + 1;
            int m = randF.nextInt(12) + 1;
            String date = ch + "." + Integer.toString(m) + ".22";
            dates.add(date);
            int h_1 = randF.nextInt(24);
            int min_1 = randF.nextInt(60);
            String m123 = "";
            String h123 = "";
            if (min_1 < 10) m123 = "0";
            if (h_1 < 10) h123 = "0";
            m123 = m123 + min_1;
            h123 = h123 + h_1;
            String time_1 = h123 + ":" + m123;
            int h_2 = randF.nextInt(24);
            int min_2 = randF.nextInt(60);
            m123 = "";
            h123 = "";
            if (min_2 < 10) m123 = "0";
            if (h_2 < 10) h123 = "0";
            m123 = m123 + min_2;
            h123 = h123 + h_2;
            String time_2 = h123 + ":" + m123;
            int bool = randF.nextInt(2);
            boolean service;
            service = bool == 1;
            int seats = randF.nextInt(150);
            int cost = randF.nextInt(1000) + 100;
            Airport a_1 = Airport.airports.get(randF.nextInt(size));
            Airport a_2 = Airport.airports.get(randF.nextInt(size));
            if (!a_1.compare(a_2)){
                Flight.flights.add(new Flight(a_1, a_2, date, time_1,time_2, service, seats, cost, admin));
            }
        }
        System.out.println(Flight.flights);
    }
    public static void foo(){}
}
