package com.dywtpag.shattered;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileUploadController {

    public static BufferedImage imgToChop;
    public ImageView choosenImg;
    public AnchorPane anchor;
    public Button uploadbtn;
    public Button togameBtn;
    public ImageView volumecontroll;
    Stage stage;
    Scene scene;

    @FXML
    public void initialize() {
        //grabs the background image
        Image image = new Image(HelloApplication.class.getResource("uploader-img.jpeg").toString());

        //allows the image to be scaled by the window size
        BackgroundImage bgImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0, 1.0, true, true, false, false));

        //sets the background of the root pane to the background image
        anchor.setBackground(new Background(bgImage));
//
        HelloController.movementAnimation(uploadbtn);
        HelloController.movementAnimation(togameBtn);

        //Initial image set for the background music. this carries over from the home menu
        Image muted = new Image(HelloApplication.class.getResource("muted-volume.png").toString());
        Image Full = new Image(HelloApplication.class.getResource("volume-on.png").toString());

        if (HelloController.volumeOn) {
            volumecontroll.setImage(Full);
        } else if (!HelloController.volumeOn) {
            volumecontroll.setImage(muted);
        }
    }

    @FXML
    protected void backToHome(ActionEvent event) throws IOException {
        Parent home_page = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(home_page);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    //Set back to private void after testing puzzle function
    public void uploadAnImage() throws IOException {
        FileChooser fileChooser = new FileChooser();

        //this is our filter for the file types
        FileChooser.ExtensionFilter jpgFilter = new FileChooser.ExtensionFilter("any jpg file", "*.jpg");
        FileChooser.ExtensionFilter JPGFilter = new FileChooser.ExtensionFilter("any jpg file", "*.JPG");
        FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("any png file", "*.png");
        FileChooser.ExtensionFilter PNGFilter = new FileChooser.ExtensionFilter("any png file", "*.PNG");

        //add these filters to the file chooser
        fileChooser.getExtensionFilters().addAll(jpgFilter, JPGFilter, pngFilter, PNGFilter);

        //file opening dialogue
        File file = fileChooser.showOpenDialog(null);

        //read the file as an image with image IO
        BufferedImage buffedImg = ImageIO.read(file);
        Image img = SwingFXUtils.toFXImage(buffedImg, null);

        //set imgviewr to chossen file
        choosenImg.setImage(img);

        imgToChop = buffedImg;
    }

    @FXML
    protected void moveToGame(ActionEvent event) throws IOException {

        // gets the width and height of the device the app is loaded on
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth() - 700;
        int height = gd.getDisplayMode().getHeight() - 400;

        Parent game = FXMLLoader.load(getClass().getResource("game.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(game, width, height);
        stage.setScene(scene);
        stage.show();
    }

    public void mute() {
        Image muted = new Image(HelloApplication.class.getResource("muted-volume.png").toString());
        Image Full = new Image(HelloApplication.class.getResource("volume-on.png").toString());

        if (HelloController.volumeOn) {
            volumecontroll.setImage(muted);
            HelloController.volumeOn = false;
        } else if (!HelloController.volumeOn) {
            volumecontroll.setImage(Full);
            HelloController.volumeOn = true;
        }

    }
}
