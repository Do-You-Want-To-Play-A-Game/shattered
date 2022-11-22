package com.dywtpag.shattered;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameTest extends Application
{

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws IOException
    {
        BufferedImage image = ImageIO.read(getClass().getResource("japa-walpaper.jpg"));
        FileUploadController.imgToChop = image;

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("game.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1300,800);
//		helloController.movementAnimation();
        stage.setTitle("Shattered!");
        stage.setScene(scene);
        stage.show();
	}
}
