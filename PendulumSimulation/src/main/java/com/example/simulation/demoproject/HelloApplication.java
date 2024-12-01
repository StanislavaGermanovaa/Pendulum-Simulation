package com.example.simulation.demoproject;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("springPendulum.fxml"));

        Scene scene = new Scene(fxmlLoader.load(),WIDTH,HEIGHT,true);

        scene.setFill(Color.SILVER);
        stage.setTitle("Pendulum");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}