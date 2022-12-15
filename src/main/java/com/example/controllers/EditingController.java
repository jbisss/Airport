package com.example.controllers;

import com.example.classes.Elements;
import com.example.classes.Flight;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Date;

public class EditingController {
    public TextField fieldDeparture;
    public TextField fieldDestination;
    public TextField fieldDate;
    public TextField fieldTime;
    public Button buttonCancel;
    public Button buttonSave;
    public TextField fieldTime1;
    public TextField textSeats;
    public TextField textClass;

    public void initialize(){
        fieldDeparture.setText(Flight.flightToChange.departure.getCity());
        fieldDestination.setText(Flight.flightToChange.destination.getCity());
        fieldDate.setText(Flight.flightToChange.getDate());
        Elements.dates.remove(Flight.flightToChange.getDate());
        fieldTime.setText(Flight.flightToChange.getDepartureTime());
        fieldTime1.setText(Flight.flightToChange.getDestinationTime());
        textSeats.setText(Integer.toString(Flight.flightToChange.getSeatsNumber()));
        if (Flight.actualFlight.getServiceClass()){
            textClass.setText("Бизнес");
        } else {
            textClass.setText("Эконом");
        }
    }
    public void buttonSaveClick(){
        char[] date = fieldDate.getText().toCharArray();
        int f_1 = (date[0]-48) * 10 + date[1] - 48;
        int f_2 = (date[3]-48) * 10 + date[4] - 48;
        int f_3 = (date[6] -48)* 10 + date[7] - 48;
        System.out.println(f_1);
        System.out.println(f_2);
        System.out.println(f_3);
        if (f_1 < 32 && f_2 < 13 && f_3 < 23){
            Flight.flightToChange.departure.setCity(fieldDeparture.getText());
            Flight.flightToChange.destination.setCity(fieldDestination.getText());
            Flight.flightToChange.setDate(fieldDate.getText());
            Elements.dates.add(fieldDate.getText());
            Flight.flightToChange.setDepartureTime(fieldTime.getText());
            Flight.flightToChange.setDestinationTime(fieldTime1.getText());
            Flight.flightToChange.setSeatsNumber(Integer.parseInt(textSeats.getText()));
            Flight.flightToChange.setServiceClass(textClass.getText().equals("Бизнес"));
            System.out.println(Flight.flights);
            buttonCancelClick();
        } else {
            System.out.println("Invalid date!");
        }

    }
    public void buttonCancelClick(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("admin_panel.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Register");
            stage.setScene(scene);
            stage.show();
            Stage stagePrev = (Stage) textSeats.getScene().getWindow();
            stagePrev.hide();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
