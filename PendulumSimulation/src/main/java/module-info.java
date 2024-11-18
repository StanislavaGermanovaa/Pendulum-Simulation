module com.example.simulation.demoproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.simulation.demoproject to javafx.fxml;
    exports com.example.simulation.demoproject;
    exports com.example.simulation.demoproject.controllers;
    opens com.example.simulation.demoproject.controllers to javafx.fxml;
}