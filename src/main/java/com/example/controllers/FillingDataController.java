package com.example.controllers;

import com.example.classes.Flight;
import com.example.classes.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FillingDataController {
    public Label textLogin;
    public TextField fieldSurname;
    public TextField fieldName;
    public TextField fieldMiddleName;
    public TextField fieldPassSeries;
    public TextField fieldPassNumber;
    public TextField fieldCardNumber;
    public TextField fieldPin;
    public Button buttonCancel;
    public Button buttonNext;
    public void buttonCancelClick(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("choosing_flight.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Поиск билета");
            stage.setScene(scene);
            stage.show();
            Stage stagePrev = (Stage) buttonCancel.getScene().getWindow();
            stagePrev.hide();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public void buttonNextClick(){
        User.actualUser.setName(fieldName.getText());
        User.actualUser.setSurname(fieldSurname.getText());
        User.actualUser.setMiddleName(fieldMiddleName.getText());
        User.actualUser.setPassNumber(Integer.parseInt(fieldPassNumber.getText()));
        User.actualUser.setPassSeries(Integer.parseInt(fieldPassSeries.getText()));
        if (fieldCardNumber.getText().equals(Integer.toString(User.actualUser.card.getNumber()))
                && fieldPin.getText().equals(Integer.toString(User.actualUser.card.getPinCode()))){
            String result = User.actualUser.card.decreaseMoney(Flight.actualFlight.getCost());
            if (result.equals("Success")) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("flight_info.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Поиск билета");
                    stage.setScene(scene);
                    stage.show();
                    Stage stagePrev = (Stage) buttonCancel.getScene().getWindow();
                    stagePrev.hide();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            System.out.println(result);
        }
    }
}
