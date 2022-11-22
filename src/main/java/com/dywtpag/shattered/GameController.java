package com.dywtpag.shattered;

import com.dywtpag.shattered.puzzle.PuzzleCreator;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class GameController {

    public AnchorPane anchor;
    public TextField timeBox;
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
        //grabs the background image
        Image image = new Image(HelloApplication.class.getResource("tableTop.jpeg").toString());

        //allows the image to be scaled by the window size
        BackgroundImage bgImage = new BackgroundImage(image,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0,1.0,true, true, false,false));

        //sets the background of the root pane to the background image
        anchor.setBackground(new Background(bgImage));
        timer.start();
    }

    @FXML
    protected void backToHome(ActionEvent event) throws IOException {
        Parent home_page = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(home_page);
        stage.setScene(scene);
        stage.show();
    }

    //Puzzle timer section

    int elapsedTime = 0;
    int seconds = 0;
    int minuets = 0;
    int hours = 0;
     Timer timer = new Timer(1000, new ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent e) {
             elapsedTime += 1000;
             seconds = (elapsedTime / 1000) % 60;
             minuets = (elapsedTime / 60000) % 60;
             hours = (elapsedTime / 36000000);

             timeBox.setText(hours+":"+minuets+":"+seconds);
         }
     });

}
