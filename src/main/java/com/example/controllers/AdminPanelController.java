package com.example.controllers;

import com.example.classes.Flight;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminPanelController {
    public ScrollPane scrollPaneFlights;
    public Button buttonExit;
    public Button buttonAddFlight;
    public VBox vBox;

    public void initialize(){
        for (Flight flight : Flight.flights) {
            HBox hBox = new HBox();
            Button button = new Button("Изменить");
            button.setOnAction(actionEvent -> {
                Flight.flightToChange = flight;
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("editing.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Register");
                    stage.setScene(scene);
                    stage.show();
                    Stage stagePrev = (Stage) buttonExit.getScene().getWindow();
                    stagePrev.hide();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });
            button.setPrefWidth(90);
            TextField textField = new TextField();
            textField.setPrefWidth(300);
            textField.setText(flight.departure.getCity() + " - " + flight.destination.getCity());
            hBox.getChildren().add(textField);
            hBox.getChildren().add(button);
            vBox.getChildren().add(hBox);
        }
    }
    public void buttonAddFlightClick(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("adding.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Register");
            stage.setScene(scene);
            stage.show();
            Stage stagePrev = (Stage) buttonExit.getScene().getWindow();
            stagePrev.hide();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public void buttonExitClick(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("enter.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Register");
            stage.setScene(scene);
            stage.show();
            Stage stagePrev = (Stage) buttonExit.getScene().getWindow();
            stagePrev.hide();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
