package com.dywtpag.shattered;

import bhlieberman.s3.client.Client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class GalleryView {
    @FXML
    public GridPane imageGallery;
    @FXML
    public Button home;
    Stage stage;

    Scene scene;

    private final ArrayList<BufferedImage> s3Images = new ArrayList<>();


    // Home Route
    @FXML
    protected void backToHome(ActionEvent event) throws IOException {
        Parent home_page = FXMLLoader.load(getClass().getResource("home.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(home_page);
        stage.setScene(scene);
        stage.show();
    }

    private void loadS3Images(String bucket, String key) {
        BufferedImage s3Result = Client.getImage(bucket, key);
        s3Images.add(s3Result);
    }


}
