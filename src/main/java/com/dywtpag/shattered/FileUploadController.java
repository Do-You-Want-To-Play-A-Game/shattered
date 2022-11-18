package com.dywtpag.shattered;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FileUploadController {
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
}
