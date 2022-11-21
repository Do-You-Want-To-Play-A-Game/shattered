package com.dywtpag.shattered;

import com.dywtpag.shattered.puzzle.PuzzleCreator;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class GameController {

    DraggableMouse draggableMouse = new DraggableMouse();

    @FXML
    public Pane main;

    public void makeGame() throws IOException {
        ArrayList<BufferedImage> puzzle = PuzzleCreator.createPuzzle(FileUploadController.imgToChop, 5, 5);

        for (int i = 0; i < puzzle.size(); i++) {
            BufferedImage bufferedImage = puzzle.get(i);

            Image piece = SwingFXUtils.toFXImage(bufferedImage, null);

            ImageView imgPiece = new ImageView();
            imgPiece.setImage(piece);

            draggableMouse.makeDraggable(imgPiece);

            main.getChildren().add(imgPiece);
        }
    }

    @FXML
    public void initialize() throws IOException {
        makeGame();
    }
}
