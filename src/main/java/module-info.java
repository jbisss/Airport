module com.example.airport {
    requires javafx.controls;
    requires javafx.fxml;
    exports com.example.controllers;
    opens com.example.controllers to javafx.fxml;
}