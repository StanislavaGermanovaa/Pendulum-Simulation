package com.example.simulation.demoproject.controllers;

import com.example.simulation.demoproject.models.SmartGroup;
import javafx.fxml.FXML;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SubScene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Sphere;

public class Pendulum {

    @FXML
    private PerspectiveCamera camera;

    @FXML
    private BorderPane borderPane;
    @FXML
    private SubScene subScene;

    @FXML
    private Box pendulumSide1, pendulumSide2, pendulumTop, pendulumBase;

    @FXML
    private Circle circle;

    @FXML
    private Line line;

    @FXML
    private Sphere sphere;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Slider sliderLength, sliderMass, sliderAngle;

    @FXML
    private VBox VBox;
//
//    @FXML
//    private TextField KeTextField, PeTextField;

    private final double GRAVITY = 9.81; // ускорение на гравитацията
    private final SmartGroup group = new SmartGroup();

    // Стойности за махалото
    private double length;  // Начална дължина
    private double mass = 1.0;    // Начална маса
    private double angle = 30;    // Начален ъгъл (в градуси)

    public void initialize() {
        prepareBox(pendulumSide1);
        prepareBox(pendulumSide2);
        prepareBox(pendulumTop);
        prepareBox(pendulumBase);
        prepareSphere(sphere);

        group.getChildren().addAll(pendulumSide1, pendulumSide2, pendulumTop, pendulumBase,circle,line,sphere);
        group.enableMouseRotation(anchorPane);

        subScene.setRoot(group);
        subScene.setCamera(camera);

    }


    private void prepareBox(Box box) {
        PhongMaterial material=new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/images/wood.jpeg")));
        material.setBumpMap(new Image(getClass().getResourceAsStream("/images/woodBumpMap.jpeg")));
        material.setSpecularColor(Color.GRAY);
        box.setVisible(true);

        box.setMaterial(material);
    }

    private void  prepareSphere(Sphere sphere){
        PhongMaterial material=new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream("/images/metal.jpeg")));
        material.setSpecularColor(Color.GRAY);
        sphere.setVisible(true);
        sphere.setMaterial(material);
    }

}
