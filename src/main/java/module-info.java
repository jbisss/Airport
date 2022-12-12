module com.example.airport {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.airport to javafx.fxml;
    exports com.example.airport;
    exports com.example.airport.controllers;
    opens com.example.airport.controllers to javafx.fxml;
}