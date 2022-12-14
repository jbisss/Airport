package com.example.controllers;

import com.example.classes.Elements;
import com.example.classes.Flight;
import com.example.classes.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PcPageController {
    public Label textLogin;
    public Button buttonBuy;
    public Button buttonExit;
    public ScrollPane scrollFlights;
    public VBox vBoxInScroll;

    public void refreshFlights(){
        vBoxInScroll.getChildren().removeAll(Flight.flightsHBox);
        Flight.flightsHBox.clear();
        for (Flight  flight : User.actualUser.usersFlight) {
            HBox hBox = flight.hBox;
            hBox.getChildren().clear();
        }
        for (Flight  flight : User.actualUser.usersFlight) {
            HBox hBox = flight.hBox;
            TextField textField = new TextField();
            textField.setText(String.valueOf(flight));
            textField.setPrefWidth(410);
            hBox.getChildren().add(textField);
            Flight.flightsHBox.add(hBox);
            try {
                hBox.getChildren().add(flight.buttonRefund);
            } catch (Exception exception) {
                System.out.println(flight.buttonRefund);
            }
            vBoxInScroll.getChildren().add(hBox);
        }
    }
    public void initialize(){
        textLogin.setText("Login:" + User.actualUser.getLogin());
        Elements.vBox = vBoxInScroll;
        refreshFlights();
    }
    public void buttonExitClick(){
        Stage stagePrev = (Stage) buttonExit.getScene().getWindow();
        stagePrev.hide();
    }
    public void buttonBuyClick(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("flight_searching.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Поиск билета");
            stage.setScene(scene);
            stage.show();
            Stage stagePrev = (Stage) buttonBuy.getScene().getWindow();
            stagePrev.hide();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
