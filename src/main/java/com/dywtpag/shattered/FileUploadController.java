package com.dywtpag.shattered;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileUploadController {

    private static BufferedImage imgToChop;
    public ImageView chosenImg;
    Stage stage;
    Scene scene;

    @FXML
    protected void backToHome(ActionEvent event) throws IOException {
        Parent home_page = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
        fileChooser.getExtensionFilters().addAll(jpgFilter,JPGFilter,pngFilter,PNGFilter);

        //file opening dialogue
        File file = fileChooser.showOpenDialog(null);

        //read the file as an image with image IO
        BufferedImage buffedImg = ImageIO.read(file);
        Image img = SwingFXUtils.toFXImage(buffedImg, null);

        //set ImageView to chosen file
        chosenImg.setImage(img);

        imgToChop = buffedImg;
    }

    @FXML
        protected void moveToGame(ActionEvent event) throws IOException {

            Parent game = FXMLLoader.load(getClass().getResource("game.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(game);
            stage.setScene(scene);
            stage.show();
        }

    public static BufferedImage getImgToChop()
    {
        return imgToChop;
    }

    public static void setImgToChop(BufferedImage imgToChop)
    {
        FileUploadController.imgToChop = imgToChop;
    }
}
