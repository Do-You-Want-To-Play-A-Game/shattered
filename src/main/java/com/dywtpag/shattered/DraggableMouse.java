package com.dywtpag.shattered;

import javafx.scene.Node;

public class DraggableMouse {

    double mouseX;
    double mouseY;

    public void makeDraggable(Node node){

        node.setOnMousePressed(mouseEvent -> {
            mouseX = mouseEvent.getX();
            mouseY = mouseEvent.getY();
        });

        node.setOnMouseDragged(mouseEvent ->{
            node.setLayoutX(mouseEvent.getSceneX() -  mouseX);
            node.setLayoutY(mouseEvent.getSceneY() - mouseY - 100);
        });
    }
}
