package com.example.controllers;

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

import java.util.ArrayList;
import java.util.Random;

public class ChoosingFlightController {
    public Label textDepartureDestination;
    public Label textLogin;
    public Label textDate;
    public Label textRate;
    public ScrollPane scrollPaneTimetable;
    public Button buttonBack;
    public VBox vBox;

    public static int costPay;
    public void initialize(){
        textDepartureDestination.setText(Flight.actualFlight.departure.getCity()
                + " - " + Flight.actualFlight.destination.getCity());
        textLogin.setText(User.actualUser.getLogin());
        textDate.setText(Flight.actualFlight.getDate());
        for (Flight flight : Flight.flights) {
            if (flight.getDate().equals(Flight.actualFlight.getDate())
                    && flight.departure.getCity().equals(Flight.actualFlight.departure.getCity())
                    && flight.destination.getCity().equals(Flight.actualFlight.destination.getCity())
                    && flight.getServiceClass() == Flight.actualFlight.getServiceClass()) {
                HBox hBox = new HBox();
                TextField timeDep = new TextField(flight.getDepartureTime());
                TextField timeDes = new TextField(flight.getDestinationTime());
                TextField cost = new TextField(Integer.toString(flight.getCost()));
                Button button = new Button("Выбрать");
                timeDep.setPrefWidth(160);
                timeDes.setPrefWidth(120);
                cost.setPrefWidth(100);
                button.setPrefWidth(100);
                button.setOnAction(actionEvent -> {
                    try {
                        Flight.actualFlight.setCost(Integer.parseInt(cost.getText()));
                        Flight.actualFlight.setOwner(User.actualUser);
                        Flight.actualFlight.setDepartureTime(timeDep.getText());
                        Flight.actualFlight.setDestinationTime(timeDes.getText());
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("filling_data.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        Stage stage = new Stage();
                        stage.setTitle("Register");
                        stage.setScene(scene);
                        stage.show();
                        Stage stagePrev = (Stage) textRate.getScene().getWindow();
                        stagePrev.hide();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                });
                hBox.getChildren().add(timeDep);
                hBox.getChildren().add(timeDes);
                hBox.getChildren().add(cost);
                hBox.getChildren().add(button);
                vBox.getChildren().add(hBox);
            }
        }
    }
    public void buttonBackClick(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("flight_searching.fxml"));
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
