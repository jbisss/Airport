package com.example.controllers;

import com.example.classes.Admin;
import com.example.classes.Elements;
import com.example.classes.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EnterController {

    public Button buttonEnter;
    public Button buttonRegister;
    public TextField fieldLogin;
    public TextField fieldPassword;

    public void buttonEnterClick(){
        Elements.foo();
        if (User.findUser(fieldLogin.getText(), fieldPassword.getText())!=null) {
            User.actualUser = User.findUser(fieldLogin.getText(), fieldPassword.getText());
            if (User.actualUser instanceof Admin) {
                openWindow("admin_panel.fxml");
            } else {
                openWindow("pc_page.fxml");
            }
        }
    }

    private void openWindow(String window) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource(window));
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

    public void buttonRegisterClick(){
        openWindow("register.fxml");
    }
}