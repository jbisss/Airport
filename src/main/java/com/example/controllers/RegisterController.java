package com.example.controllers;

import com.example.classes.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController {
    public TextField fieldLogin;
    public TextField fieldPassword;
    public Button buttonRegister;
    public void buttonRegisterClick(){
        if ((User.findUser(fieldLogin.getText(), fieldPassword.getText()) == null)) {
            User.actualUser = new User(fieldLogin.getText(), fieldPassword.getText(), 1234, 1234);
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("pc_page.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Register");
                stage.setScene(scene);
                stage.show();
                Stage stagePrev = (Stage) buttonRegister.getScene().getWindow();
                stagePrev.hide();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
