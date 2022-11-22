package com.dywtpag.shattered;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class HelloApplication extends Application
{

	@Override
	public void start(Stage stage) throws IOException
	{
		
		Image icon = new Image(HelloApplication.class.getResource("testIcon.jpeg").toString());
		HelloController helloController = new HelloController();

		// gets the width and height of the device the app is loaded on
		GraphicsDevice gd  = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int width = gd.getDisplayMode().getWidth() - 700;
		int height = gd.getDisplayMode().getHeight() - 400;
		
		FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("home.fxml"));

		//Sets the width and height of the window to the graphical interface height and width divided by 2
		Scene scene = new Scene(fxmlLoader.load(),width,height);

		stage.getIcons().add(icon);
		stage.setTitle("Shattered!");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args)
	{
		launch();
	}
}