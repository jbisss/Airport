package com.example.controllers;

import com.example.classes.Airport;
import com.example.classes.Elements;
import com.example.classes.Flight;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Random;

public class AddingController {
    public TextField fieldDeparture;
    public TextField fieldDestination;
    public TextField fieldDate;
    public TextField fieldTime;
    public Button buttonCancel;
    public Button buttonAdd;
    public TextField fieldSeats;
    public TextField fieldClass;
    public TextField fieldTime1;

    public void buttonCancelClick(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("admin_panel.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Register");
            stage.setScene(scene);
            stage.show();
            Stage stagePrev = (Stage) buttonAdd.getScene().getWindow();
            stagePrev.hide();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public void buttonAddClick(){
        int i = Airport.cities.indexOf(fieldDeparture.getText());
        Airport a_1 = new Airport(fieldDeparture.getText(), Airport.names.get(i));
        i = Airport.cities.indexOf(fieldDestination.getText());
        Airport a_2 = new Airport(fieldDestination.getText(), Airport.names.get(i));
        boolean flag;
        if (fieldClass.getText().equals("Бизнес")) flag = true;
        else flag = false;
        Random random = new Random();
        int otv = random.nextInt(1000) + 100;
        int otv_1 = random.nextInt(150) + 1;
        Flight.flights.add(new Flight(a_1, a_2, fieldDate.getText(), fieldTime.getText(), fieldTime1.getText(), flag, otv_1, otv, Elements.adminMain));
        Elements.dates.add(fieldDate.getText());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("admin_panel.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Register");
            stage.setScene(scene);
            stage.show();
            Stage stagePrev = (Stage) buttonAdd.getScene().getWindow();
            stagePrev.hide();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
