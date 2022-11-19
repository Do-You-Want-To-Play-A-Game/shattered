package com.dywtpag.shattered;

import com.dywtpag.shattered.puzzle.PuzzleCreator;
import com.dywtpag.shattered.puzzle.PuzzleNode;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class GameController {

    @FXML
    public AnchorPane main;

    public void makeGame() throws IOException {
        ArrayList<PuzzleNode> puzzle = PuzzleCreator.createPuzzle(FileUploadController.getImgToChop(), 1920, 1080);
        //todo let rows and columns be changed

        for (PuzzleNode puzzleNode : puzzle)
        {
            main.getChildren().add(puzzleNode);
        }
    }

    @FXML
    public void initialize() throws IOException {
        makeGame();
    }
}
