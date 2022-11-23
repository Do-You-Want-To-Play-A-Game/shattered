package com.dywtpag.shattered;

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

        Image imageBack = new Image(HelloApplication.class.getResource("AdobeStock_268548990.jpeg").toString());

        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1.0,1.0,true,true,false,false));


        anchor.setBackground(new Background(backgroundImage));



        Image image = new Image(HelloApplication.class.getResource("test.png").toString());
        ArrayList<ImageView> imageArrayList = new ArrayList<ImageView>();
        ImageView imageview = new ImageView();
        imageview.setImage(image);
        imageview.setFitHeight(100);
        imageview.setFitWidth(100);
        ImageView imageview1 = new ImageView();
        imageview1.setImage(image);
        imageview1.setFitHeight(100);
        imageview1.setFitWidth(100);
        ImageView imageview2 = new ImageView();
        imageview2.setImage(image);
        imageview2.setFitHeight(100);
        imageview2.setFitWidth(100);
        ImageView imageview3 = new ImageView();
        imageview3.setImage(image);
        imageview3.setFitHeight(100);
        imageview3.setFitWidth(100);
        ImageView imageview4 = new ImageView();
        imageview4.setImage(image);
        imageview4.setFitHeight(100);
        imageview4.setFitWidth(100);
        ImageView imageview5 = new ImageView();
        imageview5.setImage(image);
        imageview5.setFitHeight(100);
        imageview5.setFitWidth(100);
        ImageView imageview6 = new ImageView();
        imageview6.setImage(image);
        imageview6.setFitHeight(100);
        imageview6.setFitWidth(100);
        ImageView imageview7 = new ImageView();
        imageview7.setImage(image);
        imageview7.setFitHeight(100);
        imageview7.setFitWidth(100);
        ImageView imageview8 = new ImageView();
        imageview8.setImage(image);
        imageview8.setFitHeight(100);
        imageview8.setFitWidth(100);
        ImageView imageview9 = new ImageView();
        imageview9.setImage(image);
        imageview9.setFitHeight(100);
        imageview9.setFitWidth(100);
        ImageView imageview10 = new ImageView();
        imageview10.setImage(image);
        imageview10.setFitHeight(100);
        imageview10.setFitWidth(150);
        imageArrayList.add(imageview);
        imageArrayList.add(imageview1);
        imageArrayList.add(imageview2);
        imageArrayList.add(imageview3);
        imageArrayList.add(imageview4);
        imageArrayList.add(imageview5);
        Integer currRow = -1;
        for (int i = 0; i < imageArrayList.size(); i++) {
          if ( i % 3 == 0 ) {
                currRow++;
            }
            imageGallery.add( imageArrayList.get(i),i % 3, currRow );
            System.out.println(imageGallery);
      }

        }
    }
