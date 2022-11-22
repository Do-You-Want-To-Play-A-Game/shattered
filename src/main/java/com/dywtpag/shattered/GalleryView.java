package com.dywtpag.shattered;

import com.dywtpag.shattered.aws.S3;
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
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GalleryView {


    @FXML
    public GridPane imageGallery;
    @FXML
    public Button home;

    @FXML
    public Button Uploader;

    @FXML
    public Pane anchor;

    Stage stage;

    Scene scene;

    private ArrayList<Image> s3Images = new ArrayList<>();


    // Home Route
    @FXML
    protected void backToHome(ActionEvent event) throws IOException {
        Parent home_page = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(home_page);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void toUploader(ActionEvent event) throws IOException {
        Parent uploader = FXMLLoader.load(getClass().getResource("file-upload.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(uploader);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void initialize() throws IOException {
        s3Images = loadS3Images("images-jigsaw-game", "self.jpg");
        Image imageBack = new Image(HelloApplication.class.getResource("AdobeStock_268548990.jpeg").toString());

        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0,1.0,true,true,false,false));


        anchor.setBackground(new Background(backgroundImage));

        Integer currRow = -1;
        for (int i = 0; i < s3Images.size(); i++) {
          if ( i % 3 == 0 ) {
                currRow++;
            }
            imageGallery.add(new ImageView(s3Images.get(i)),i % 3, currRow );
            System.out.println(imageGallery);
      }

        }
    private ArrayList<Image> loadS3Images(String bucket, String key) throws IOException {
        ArrayList<Image> s3Images = new ArrayList<>();
        BufferedImage s3Result = S3.getImage(bucket, key);
        s3Images.add(SwingFXUtils.toFXImage(s3Result, null));
        return s3Images;
    }
    }
