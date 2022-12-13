package com.example.controllers;

import com.example.classes.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PcPageController {
    public Label textLogin;
    public Button buttonBuy;
    public Button buttonExit;

    public void initialize(){
        textLogin.setText("Login:" + User.actualUser.getLogin());
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
