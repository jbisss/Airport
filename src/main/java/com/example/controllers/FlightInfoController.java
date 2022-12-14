package com.example.controllers;

import com.example.classes.Flight;
import com.example.classes.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FlightInfoController {
    public Label textLogin;
    public TextField fieldSurname;
    public TextField fieldName;
    public TextField fieldMiddleName;
    public TextField fieldSeries;
    public TextField fieldNumber;
    public TextField fieldFlight;
    public TextField fieldDate;
    public TextField fieldDeparture;
    public TextField fieldDestination;
    public TextField fieldPlace;
    public Button buttonBack;
    public void initialize(){
        Flight.actualFlight.setOwner( User.actualUser);
        User.actualUser.usersFlight.add(Flight.actualFlight);
        fieldName.setText(User.actualUser.getName());
        fieldSurname.setText(User.actualUser.getSurname());
        fieldMiddleName.setText(User.actualUser.getMiddleName());
        fieldNumber.setText(Integer.toString(User.actualUser.getPassNumber()));
        fieldSeries.setText(Integer.toString(User.actualUser.getPassSeries()));
        fieldFlight.setText(Flight.actualFlight.departure.getName() + " " + Flight.actualFlight.departure.getCity()
                + " - " + Flight.actualFlight.destination.getName() + " " + Flight.actualFlight.destination.getCity());
        fieldDate.setText(Flight.actualFlight.getDate());
        fieldDeparture.setText(Flight.actualFlight.departure.getCity());
        fieldDestination.setText(Flight.actualFlight.destination.getCity());
        fieldPlace.setText(Integer.toString(Flight.actualFlight.getSeatsNumber()));
    }
    public void buttonBackClick(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("pc_page.fxml"));
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
