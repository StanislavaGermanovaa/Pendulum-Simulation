package com.example.simulation.demoproject.models;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.transform.Rotate;

public class SmartGroup extends Group {

    private Rotate rotateX = new Rotate(0, Rotate.X_AXIS);
    private Rotate rotateY = new Rotate(0, Rotate.Y_AXIS);
    private Rotate rotateZ = new Rotate(0, Rotate.Z_AXIS);

    public SmartGroup() {
        // Добавяне на всички ротации към групата
        this.getTransforms().addAll(rotateX, rotateY, rotateZ);
    }
    public void rotateByX(int angle) {
        rotateX.setAngle(rotateX.getAngle() + angle);
    }

    public void rotateByY(int angle) {
        rotateY.setAngle(rotateY.getAngle() + angle);
    }
    public void rotateByZ(int angle) {
        rotateZ.setAngle(rotateZ.getAngle() + angle);
    }

    public void resetRotations() {
        rotateX.setAngle(0);
        rotateY.setAngle(0);
        rotateZ.setAngle(0);
    }

    public void enableMouseRotation(Node node) {
        final double[] mousePos = new double[2];

        node.setOnMousePressed(event -> {
            mousePos[0] = event.getSceneX();
            mousePos[1] = event.getSceneY();
        });

        node.setOnMouseDragged(event -> {
            double deltaX = event.getSceneX() - mousePos[0];
            double deltaY = event.getSceneY() - mousePos[1];

            rotateByY((int) (-deltaX * 0.3));

            rotateByX((int) (deltaY * 0.3));

            mousePos[0] = event.getSceneX();
            mousePos[1] = event.getSceneY();
        });
    }
}
