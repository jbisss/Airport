package com.example.controllers;

import com.example.classes.Airport;
import com.example.classes.Elements;
import com.example.classes.Flight;
import com.example.classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class FlightSearchingController {
    public Label textLogin;
    public ComboBox<String> comboDeparture;
    public ComboBox<String> comboDestination;
    public ComboBox<String> comboDate;
    public ComboBox<String> comboRate;
    public Button buttonBack;
    public Button buttonNext;

    public void initialize(){
        ObservableList<String> cities = FXCollections.observableArrayList(Airport.cities);
        ObservableList<String> rates = FXCollections.observableArrayList("Эконом", "Бизнес");
        ObservableList<String> dates = FXCollections.observableArrayList(Elements.dates);
        comboDeparture.setItems(cities);
        comboDestination.setItems(cities);
        comboDate.setItems(dates);
        comboRate.setItems(rates);

    }
    public void buttonBackClick(){
        goAnotherWindow(buttonBack, "pc_page.fxml");
    }
    public void buttonNextClick(){
        boolean rate = comboRate.getValue().equals("Бизнес");
        int x_1 = Airport.cities.indexOf(comboDeparture.getValue());
        int x_2 = Airport.cities.indexOf(comboDestination.getValue());
        Airport departure = new Airport(comboDeparture.getValue(), Airport.names.get(x_1));
        Airport destination = new Airport(comboDestination.getValue(), Airport.names.get(x_2));
        Flight.actualFlight = new Flight(departure, destination, comboDate.getValue(), rate, User.actualUser);
        goAnotherWindow(buttonNext, "choosing_flight.fxml");
    }
    private void goAnotherWindow(Button buttonBack, String window) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(window));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Поиск билета");
            stage.setScene(scene);
            stage.show();
            Stage stagePrev = (Stage) buttonBack.getScene().getWindow();
            stagePrev.hide();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
