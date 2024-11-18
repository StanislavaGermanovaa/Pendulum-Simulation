package com.example.simulation.demoproject.controllers;

import com.example.simulation.demoproject.models.SmartGroup;
import javafx.fxml.FXML;
import javafx.scene.Camera;
import javafx.scene.SubScene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;

public class Pendulum {

    @FXML
    private Camera camera;

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private SubScene subScene;

    @FXML
    private Box pendulumSide1;
    @FXML
    private Box pendulumSide2;

    @FXML
    private Box pendulumTop;

    @FXML
    private Box pendulumBase;

    private final SmartGroup group = new SmartGroup();

    private double mousePosX, mousePosY;
    private double mouseOldX, mouseOldY;
    private final Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
    private final Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);

    public Camera getCamera() {
        return camera;
    }

    public void initialize() {
        // Add the pendulum components to the SmartGroup
        group.getChildren().addAll(pendulumSide1, pendulumSide2, pendulumTop, pendulumBase);

        // Attach the rotations to the SmartGroup
        group.getTransforms().addAll(rotateX, rotateY);

        // Add the SmartGroup to the SubScene
        subScene.setRoot(group);
        subScene.setCamera(camera);

        initMouseControl(group, anchorPane);
    }

    private void initMouseControl(SmartGroup group, AnchorPane scene) {
        scene.setOnMousePressed(this::handleMousePressed);
        scene.setOnMouseDragged(this::handleMouseDragged);

        group.setOnScroll(scrollEvent -> {
            double delta = scrollEvent.getDeltaY();
            group.setTranslateZ(group.getTranslateZ() + delta);
        });

    }

    private void handleMousePressed(MouseEvent event) {
        mouseOldX = event.getSceneX();
        mouseOldY = event.getSceneY();
    }

    private void handleMouseDragged(MouseEvent event) {
        mousePosX = event.getSceneX();
        mousePosY = event.getSceneY();

        double deltaX = mousePosX - mouseOldX;
        double deltaY = mousePosY - mouseOldY;

        rotateY.setAngle(rotateY.getAngle() - deltaX * 0.3);
        rotateX.setAngle(rotateX.getAngle() + deltaY * 0.3);

        mouseOldX = mousePosX;
        mouseOldY = mousePosY;
    }
}
